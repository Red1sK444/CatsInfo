package com.r3d1r4ph.catsinfo.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CatDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(catEntities: List<CatEntity>)

    @Query("DELETE FROM cat")
    suspend fun clearAll()

    @Query("SELECT * FROM cat")
    fun pagingSource(): PagingSource<Int, CatEntity>
}