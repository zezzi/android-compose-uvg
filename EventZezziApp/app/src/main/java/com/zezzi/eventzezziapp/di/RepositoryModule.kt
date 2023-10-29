package com.zezzi.eventzezziapp.di

import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.zezzi.eventzezziapp.ui.firestore.repository.FirestoreDbRepositoryImpl
import com.zezzi.eventzezziapp.ui.firestore.repository.FirestoreRepository
import com.zezzi.eventzezziapp.ui.signup.repository.AuthRepository
import com.zezzi.eventzezziapp.ui.signup.repository.AuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun providesFirestoreRepository(
        repo: FirestoreDbRepositoryImpl
    ): FirestoreRepository

    @Binds
    abstract fun providesFirebaseAuthRepository(
        repo:AuthRepositoryImpl
    ):AuthRepository
}