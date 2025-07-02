package com.hutsy.datasource.local.source.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [],
    version = 1,
    autoMigrations = [],
)
abstract class DnDGiftsDB : RoomDatabase()