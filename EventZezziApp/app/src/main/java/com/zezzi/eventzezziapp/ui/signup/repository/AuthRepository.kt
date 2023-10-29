package com.zezzi.eventzezziapp.ui.signup.repository

import android.app.Activity
import com.zezzi.eventzezziapp.networking.ResultState
import com.zezzi.eventzezziapp.ui.signup.model.AuthUser
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    fun createUser(
        auth: AuthUser
    ) : Flow<ResultState<String>>

    fun loginUser(
        auth: AuthUser
    ) : Flow<ResultState<String>>

    fun createUserWithPhone(
        phone:String,
        activity: Activity
    ) : Flow<ResultState<String>>

    fun signWithCredential(
        otp:String
    ): Flow<ResultState<String>>
}