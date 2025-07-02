package com.hutsy.datasource.local.source.preference

import androidx.datastore.core.DataStore
import androidx.datastore.core.IOException
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

interface PreferencesHelper {
    suspend fun <D> save(
        key: Preferences.Key<D>,
        data: D,
    )

    suspend fun <D> delete(key: Preferences.Key<D>)

    fun <D> get(key: Preferences.Key<D>): Flow<D?>
}

class PreferencesHelperImpl(
    private val dataStore: DataStore<Preferences>,
) : PreferencesHelper {
    override suspend fun <D> save(
        key: Preferences.Key<D>,
        data: D,
    ) {
        dataStore.edit {
            it[key] = data
        }
    }

    override suspend fun <D> delete(key: Preferences.Key<D>) {
        dataStore.edit {
            it.remove(key)
        }
    }

    override fun <D> get(key: Preferences.Key<D>): Flow<D?> {
        return dataStore.data.map {
            it[key]
        }.catch { e ->
            if (e is IOException) emptyPreferences()
        }
    }
}