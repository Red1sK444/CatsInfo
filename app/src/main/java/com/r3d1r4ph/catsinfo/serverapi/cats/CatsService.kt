package com.r3d1r4ph.catsinfo.serverapi.cats

import com.r3d1r4ph.catsinfo.serverapi.Network

class CatsService {
    private val api = Network.retrofit.create(CatsInterface::class.java)

    suspend fun cats(limit: Int, page: Int) =
        api.cats(limit = limit, page = page, order = "ASC")
}