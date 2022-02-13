package com.r3d1r4ph.catsinfo.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatItem

@Entity(tableName = "cat")
data class CatEntity(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    val url: String
) {
    fun toDomain() = CatItem(
        id, url
    )
}