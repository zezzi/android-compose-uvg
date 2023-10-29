package com.zezzi.eventzezziapp.ui.signup.viewmodel

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.zezzi.eventzezziapp.ui.signup.model.AuthUser
import com.zezzi.eventzezziapp.ui.signup.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val repo: AuthRepository
) : ViewModel() {

    fun createUser(authUser: AuthUser) = repo.createUser(authUser)

    fun loginUser(authUser: AuthUser) = repo.loginUser(authUser)

    fun createUserWithPhone(
        mobile:String,
        activity: Activity
    ) = repo.createUserWithPhone(mobile,activity)

    fun signInWithCredential(
        code:String
    ) = repo.signWithCredential(code)
}