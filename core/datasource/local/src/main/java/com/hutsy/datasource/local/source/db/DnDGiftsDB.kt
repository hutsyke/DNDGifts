package com.hutsy.datasource.local.source.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.hutsy.datasource.local.source.db.mock.MockDbEntity

@Database(
    entities = [
        MockDbEntity::class
    ],
    version = 1,
    autoMigrations = [],
)
abstract class DnDGiftsDB : RoomDatabase()