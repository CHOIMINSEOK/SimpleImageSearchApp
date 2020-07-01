package io.minseok.imagesearchapp.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import io.minseok.imagesearchapp.data.local.model.ImageEntity
import io.reactivex.Completable

@Dao
interface ImageEntityDAO {
    @Query("SELECT * FROM imageEntity")
    fun getAll(): LiveData<List<ImageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(imageEntity: ImageEntity): Completable

    @Delete
    fun delete(imageEntity: ImageEntity): Completable
}