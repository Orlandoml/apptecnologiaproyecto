package com.example.apptecnologia.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface IADao {
    @Query("SELECT * FROM inteligencias_artificiales ORDER BY nombre ASC")
    fun getAllIAs(): Flow<List<IAEntity>>

    @Query("SELECT * FROM inteligencias_artificiales WHERE id = :id")
    suspend fun getIAById(id: Int): IAEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertIA(ia: IAEntity)

    @Update
    suspend fun updateIA(ia: IAEntity)

    @Delete
    suspend fun deleteIA(ia: IAEntity)
}
