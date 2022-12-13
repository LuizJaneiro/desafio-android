package com.picpay.desafio.android.domain.usecase

import com.picpay.desafio.android.domain.repository.PicPayRepository
import com.picpay.desafio.android.domain.utils.result.PicPayResult
import com.picpay.desafio.android.domain.utils.result.map
import com.picpay.desafio.android.domain.utils.result.mapFailure
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

@OptIn(ExperimentalCoroutinesApi::class)
class GetUsersUseCaseTest {

    @MockK private lateinit var picPayRepository: PicPayRepository
    private lateinit var useCase: GetUsersUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        useCase = GetUsersUseCase(picPayRepository)
    }


    @Test
    fun `GIVEN success result from repository WHEN useCase is executed THEN it returns success result converted to ui`() = runTest {
        //given
        val userModelList = getUserModelList()
        coEvery { picPayRepository.getUsers() } returns PicPayResult(userModelList)

        // when
        val result = useCase.invoke(Unit)

        //then
        assertTrue { !result.isFailure }
        result.map { list ->
            list.mapIndexed { index, user ->
                assertEquals(user.id, userModelList[index].id)
                assertEquals(user.name, userModelList[index].name)
                assertEquals(user.username, userModelList[index].username)
                assertEquals(user.img, userModelList[index].img)
            }
        }
    }

    @Test
    fun `GIVEN failure result from repository WHEN useCase is executed THEN it returns failure`() = runTest {
        //given
        val test = "TESTE"
        coEvery { picPayRepository.getUsers() } returns PicPayResult.failure(Throwable(message = test))

        // when
        val result = useCase.invoke(Unit)

        //then
        assertTrue { result.isFailure }
        val error = result.map {  }.mapFailure()
        assertEquals(test, (error.value as Throwable).cause?.message)
    }

}