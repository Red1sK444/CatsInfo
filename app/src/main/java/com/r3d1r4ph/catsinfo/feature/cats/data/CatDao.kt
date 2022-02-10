package com.r3d1r4ph.catsinfo.feature.cats.data

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.r3d1r4ph.catsinfo.database.CatEntity

@Dao
interface CatDao: CatsLocalDatasource {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    override suspend fun insertAll(catEntities: List<CatEntity>)

    @Query("DELETE FROM cat")
    override suspend fun clearAll()

    @Query("SELECT * FROM cat")
    override fun pagingSource(): PagingSource<Int, CatEntity>
}