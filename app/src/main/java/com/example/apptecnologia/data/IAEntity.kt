package com.example.apptecnologia.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "inteligencias_artificiales")
data class IAEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val descripcion: String
)
