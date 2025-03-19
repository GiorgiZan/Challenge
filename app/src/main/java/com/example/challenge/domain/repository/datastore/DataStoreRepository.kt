package com.example.challenge.domain.repository.datastore

import androidx.datastore.preferences.core.Preferences
import kotlinx.coroutines.flow.Flow

interface DataStoreRepository {
    suspend fun <T> saveValue(key: Preferences.Key<T>, value: T)

    fun <T> getValue(key: Preferences.Key<T>): Flow<T?>

    suspend fun clear()

}