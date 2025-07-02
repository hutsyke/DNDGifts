package com.hutsy.datasource.local.source.db.mock

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MockDb(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
)
