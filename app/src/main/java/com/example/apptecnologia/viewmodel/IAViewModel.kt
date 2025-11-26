package com.example.apptecnologia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.apptecnologia.data.AppDatabase
import com.example.apptecnologia.data.IAEntity
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class IAViewModel(application: Application) : AndroidViewModel(application) {
    private val iaDao = AppDatabase.getDatabase(application).iaDao()

    val ias: StateFlow<List<IAEntity>> = iaDao.getAllIAs()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = emptyList()
        )

    fun insertIA(nombre: String, descripcion: String) {
        viewModelScope.launch {
            iaDao.insertIA(IAEntity(nombre = nombre, descripcion = descripcion))
        }
    }

    fun updateIA(ia: IAEntity) {
        viewModelScope.launch {
            iaDao.updateIA(ia)
        }
    }

    fun deleteIA(ia: IAEntity) {
        viewModelScope.launch {
            iaDao.deleteIA(ia)
        }
    }
}
