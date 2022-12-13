package com.picpay.desafio.android.domain.repository.impl

import com.picpay.desafio.android.domain.repository.getUserEntityList
import com.picpay.desafio.android.domain.repository.getUserResponseList
import com.picpay.desafio.android.domain.utils.result.map
import com.picpay.desafio.android.mappers.toEntity
import com.picpay.desafio.android.service.database.UserDatabaseDao
import com.picpay.desafio.android.service.networking.PicPayNetworking
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class PicPayRepositoryImplTest {

    @MockK private lateinit var picPayNetworking : PicPayNetworking
    @MockK private lateinit var userDatabaseDao: UserDatabaseDao
    private lateinit var picPayRepository: PicPayRepositoryImpl

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        picPayRepository = PicPayRepositoryImpl(service = picPayNetworking, database = userDatabaseDao)
    }

    @Test
    fun `GIVEN success null result from networking WHEN getUsers is called THEN it returns success domain empty list`() =
        runTest {
            //given
            coEvery { picPayNetworking.getUsers() } returns null

            //when
            val result = picPayRepository.getUsers()

            //then
            assertTrue { !result.isFailure }
            result.map {
                assertTrue { it.isEmpty() }
            }
        }

    @Test
    fun `GIVEN failure result from networking and database WHEN getUsers is called THEN it should return failure`() =
        runTest {
            //given
            coEvery { picPayNetworking.getUsers() } throws Throwable()
            coEvery { userDatabaseDao.getAllUsers() } throws Throwable()

            //when
            val result = picPayRepository.getUsers()

            //then
            assertTrue { result.isFailure }
        }

    @Test
    fun `GIVEN failure result from networking and success from database WHEN getUsers is called THEN it should return success with database list`() =
        runTest {
            //given
            val userEntityList = getUserEntityList()
            coEvery { picPayNetworking.getUsers() } throws Throwable()
            coEvery { userDatabaseDao.getAllUsers() } returns userEntityList

            //when
            val result = picPayRepository.getUsers()

            //then
            assertTrue { !result.isFailure }
            result.map { list ->
                list.mapIndexed { index, userModel ->
                    assertEquals(userEntityList[index].id, userModel.id)
                    assertEquals(userEntityList[index].username, userModel.username)
                    assertEquals(userEntityList[index].name, userModel.name)
                    assertEquals(userEntityList[index].img, userModel.img)
                }
            }
        }

    @Test
    fun `GIVEN success result from networking WHEN getUsers is called THEN it should return success with networking list and insert items at database`() =
        runTest {
            //given
            val userResponseList = getUserResponseList()
            coEvery { picPayNetworking.getUsers() } returns userResponseList
            coEvery { userDatabaseDao.insert(any()) } returns Unit

            //when
            val result = picPayRepository.getUsers()

            //then
            assertTrue { !result.isFailure }
            result.map { list ->
                list.mapIndexed { index, userModel ->
                    assertEquals(userResponseList[index].id, userModel.id)
                    assertEquals(userResponseList[index].username, userModel.username)
                    assertEquals(userResponseList[index].name, userModel.name)
                    assertEquals(userResponseList[index].img, userModel.img)
                    coVerify (exactly = 1) { userDatabaseDao.insert(userResponseList[index].toEntity()) }
                }
            }
        }
}