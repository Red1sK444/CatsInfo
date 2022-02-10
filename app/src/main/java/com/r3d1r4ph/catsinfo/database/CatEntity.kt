package com.r3d1r4ph.catsinfo.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cat")
data class CatEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val url: String
)