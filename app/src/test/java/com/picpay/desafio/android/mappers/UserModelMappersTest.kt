package com.picpay.desafio.android.mappers

import org.junit.Test
import kotlin.test.assertEquals

class UserModelMappersTest {

    @Test
    fun `GIVEN instance of UserModel WHEN it is converted to User THEN it is converted correctly`() {
        // given
        val userModel = getUserModel()

        //when
        val user = userModel.toUi()

        // then
        assertEquals(userModel.name, user.name)
        assertEquals(userModel.id, user.id)
        assertEquals(userModel.img, user.img)
        assertEquals(userModel.username, user.username)
    }
}