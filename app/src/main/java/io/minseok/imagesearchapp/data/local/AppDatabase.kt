package io.minseok.imagesearchapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import io.minseok.imagesearchapp.data.local.model.ImageEntity

@Database(entities = arrayOf(ImageEntity::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun imageEntityDao(): ImageEntityDAO
}