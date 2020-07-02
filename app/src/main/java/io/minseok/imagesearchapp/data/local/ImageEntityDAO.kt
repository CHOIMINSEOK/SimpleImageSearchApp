package io.minseok.imagesearchapp.data.local

import androidx.room.*
import io.minseok.imagesearchapp.data.local.model.ImageEntity
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface ImageEntityDAO {
    @Query("SELECT * FROM imageEntity")
    fun getAll(): Flowable<List<ImageEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(imageEntity: ImageEntity): Completable

    @Delete
    fun delete(imageEntity: ImageEntity): Completable
}