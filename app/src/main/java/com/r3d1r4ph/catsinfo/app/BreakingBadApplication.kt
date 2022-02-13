package com.r3d1r4ph.catsinfo.app

import android.app.Application
import com.r3d1r4ph.catsinfo.database.Database
import com.r3d1r4ph.catsinfo.feature.cats.data.CatsRepositoryImpl
import com.r3d1r4ph.catsinfo.feature.cats.domain.CatsRepository

class BreakingBadApplication : Application() {
    lateinit var catsRepository: CatsRepository

    override fun onCreate() {
        super.onCreate()
        catsRepository =
            CatsRepositoryImpl(Database.getInstance(this).getCatDao(), Database.getInstance(this))
    }
}