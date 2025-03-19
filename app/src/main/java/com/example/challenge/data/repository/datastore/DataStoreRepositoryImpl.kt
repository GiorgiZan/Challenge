package com.example.challenge.data.repository.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.example.challenge.domain.repository.datastore.DataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreRepository {
    override suspend fun <T> saveValue(key: Preferences.Key<T>, value: T) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    override fun <T> getValue(key: Preferences.Key<T>): Flow<T?> {
        return dataStore.data.map { preferences ->
            preferences[key]
        }
    }

    override suspend fun clear() {
        dataStore.edit {
            it.clear()
        }
    }
}