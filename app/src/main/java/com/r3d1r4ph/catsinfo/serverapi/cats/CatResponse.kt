package com.r3d1r4ph.catsinfo.serverapi.cats

import com.r3d1r4ph.catsinfo.feature.cats.data.CatEntity
import kotlinx.serialization.Serializable

@Serializable
data class CatResponse(
    val id: String,
    val url: String
) {
    fun toEntity() = CatEntity(
        id, url
    )
}
