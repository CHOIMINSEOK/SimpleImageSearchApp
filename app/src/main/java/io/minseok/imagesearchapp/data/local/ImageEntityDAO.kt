package io.minseok.imagesearchapp.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.minseok.imagesearchapp.data.local.model.ImageEntity

@Dao
interface ImageEntityDAO {
    @Query("SELECT * FROM imageEntity")
    fun getAll(): List<ImageEntity>

    @Insert
    fun insert(imageEntity: ImageEntity)

    @Delete
    fun delete(imageEntity: ImageEntity)
}