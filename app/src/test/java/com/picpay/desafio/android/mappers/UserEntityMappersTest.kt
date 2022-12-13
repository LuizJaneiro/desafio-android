package com.picpay.desafio.android.mappers

import org.junit.Test
import kotlin.test.assertEquals

class UserEntityMappersTest {

    @Test
    fun `GIVEN instance of UserEntity WHEN it is converted to UserResponse THEN it is converted correctly`() {
        // given
        val userEntity = getUserEntity()

        //when
        val userResponse = userEntity.toResponse()

        // then
        assertEquals(userEntity.name, userResponse.name)
        assertEquals(userEntity.id, userResponse.id)
        assertEquals(userEntity.img, userResponse.img)
        assertEquals(userEntity.username, userResponse.username)
    }

    @Test
    fun `GIVEN instance of UserEntity WHEN it is converted to UserModel THEN it is converted correctly`() {
        // given
        val userEntity = getUserEntity()

        //when
        val userModel = userEntity.toDomain()

        // then
        assertEquals(userEntity.name, userModel.name)
        assertEquals(userEntity.id, userModel.id)
        assertEquals(userEntity.img, userModel.img)
        assertEquals(userEntity.username, userModel.username)
    }
}