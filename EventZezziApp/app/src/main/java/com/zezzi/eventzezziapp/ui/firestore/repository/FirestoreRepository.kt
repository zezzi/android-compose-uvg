package com.zezzi.eventzezziapp.ui.firestore.repository

import com.zezzi.eventzezziapp.networking.ResultState
import kotlinx.coroutines.flow.Flow

interface FirestoreRepository {

    fun insert(
        item:FirestoreModelResponse.FirestoreItem
    ) : Flow<ResultState<String>>

    fun getItems() : Flow<ResultState<List<FirestoreModelResponse>>>

    fun delete(key:String) : Flow<ResultState<String>>

    fun update(
        item:FirestoreModelResponse
    ) : Flow<ResultState<String>>

}