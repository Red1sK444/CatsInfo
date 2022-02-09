package com.r3d1r4ph.catsinfo.serverapi.cats

import kotlinx.serialization.Serializable

@Serializable
data class CatResponse(
    val id: String,
    val url: String
)