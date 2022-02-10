package com.r3d1r4ph.catsinfo.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CatEntity::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCatDao(): CatDao
}