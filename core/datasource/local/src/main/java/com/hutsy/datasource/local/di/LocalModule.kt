package com.hutsy.datasource.local.di

import androidx.room.Room
import com.hutsy.datasource.local.source.db.DnDGiftsDB
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val localModule = module {
    single<DnDGiftsDB> {
        Room.databaseBuilder(
            context = androidApplication(),
            klass = DnDGiftsDB::class.java,
            name = "dnd.db"
        ).build()
    }
}