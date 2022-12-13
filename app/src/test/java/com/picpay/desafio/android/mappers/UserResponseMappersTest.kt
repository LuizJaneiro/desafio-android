package com.picpay.desafio.android.mappers

import org.junit.Test
import kotlin.test.assertEquals

class UserResponseMappersTest {

    @Test
    fun `GIVEN instance of UserResponse with non null values WHEN it is converted to UserModel THEN it is converted correctly`() {
        // given
        val userResponse = getUserResponse()

        //when
        val userModel = userResponse.toDomain()

        // then
        assertEquals(userResponse.name, userModel.name)
        assertEquals(userResponse.id, userModel.id)
        assertEquals(userResponse.img, userModel.img)
        assertEquals(userResponse.username, userModel.username)
    }

    @Test
    fun `GIVEN instance of UserResponse with null values WHEN it is converted to UserModel THEN it is converted correctly`() {
        // given
        val userResponse = getNullUserResponse()

        //when
        val userModel = userResponse.toDomain()

        // then
        assertEquals( "", userModel.name)
        assertEquals(-1, userModel.id)
        assertEquals( "", userModel.img)
        assertEquals( "", userModel.username)
    }

    @Test
    fun `GIVEN instance of UserResponse with non null values WHEN it is converted to UserEntity THEN it is converted correctly`() {
        // given
        val userResponse = getUserResponse()

        //when
        val userEntity = userResponse.toEntity()

        // then
        assertEquals(userResponse.name, userEntity.name)
        assertEquals(userResponse.id, userEntity.id)
        assertEquals(userResponse.img, userEntity.img)
        assertEquals(userResponse.username, userEntity.username)
    }

    @Test
    fun `GIVEN instance of UserResponse with null values WHEN it is converted to UserEntity THEN it is converted correctly`() {
        // given
        val userResponse = getNullUserResponse()

        //when
        val userEntity = userResponse.toEntity()

        // then
        assertEquals( "", userEntity.name)
        assertEquals(null, userEntity.id)
        assertEquals( "", userEntity.img)
        assertEquals( "", userEntity.username)
    }
}