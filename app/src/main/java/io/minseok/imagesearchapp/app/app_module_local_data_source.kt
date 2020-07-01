package io.minseok.imagesearchapp.app

import android.content.Context
import androidx.room.Room
import io.minseok.imagesearchapp.data.local.AppDatabase
import org.koin.dsl.module.module

val localDataSourceAppModule = module {
    single { createRoom(get()) }

    single { get<AppDatabase>().imageEntityDao() }
}


private fun createRoom(
    applicationContext: Context
): AppDatabase {
    return Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java, "database"
    ).build()
}