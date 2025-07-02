package com.hutsy.datasource.local.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room
import com.hutsy.datasource.local.source.db.DnDGiftsDB
import com.hutsy.datasource.local.source.preference.PreferencesHelper
import com.hutsy.datasource.local.source.preference.PreferencesHelperImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.named
import org.koin.dsl.module

private val Context.localPreferences by preferencesDataStore(name = "local")
private val Context.remotePreferences by preferencesDataStore(name = "remote")

val LocalQualifier = named("local")
val RemoteQualifier = named("remote")

val localModule = module {
    single<DnDGiftsDB> {
        Room.databaseBuilder(
            context = androidApplication(),
            klass = DnDGiftsDB::class.java,
            name = "dnd.db"
        ).build()
    }

    single<PreferencesHelper>(LocalQualifier) {
        PreferencesHelperImpl(get<Context>().localPreferences)
    }
    single<PreferencesHelper>(RemoteQualifier) {
        PreferencesHelperImpl(get<Context>().remotePreferences)
    }
}