package com.mojalu75.livedata.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mojalu75.livedata.Model.AforoModel
import com.mojalu75.livedata.Model.AforoProvider

class AforoViewModel : ViewModel() {

    private val max = 10

    private val _aforo = MutableLiveData(AforoProvider.inicial())
    val aforo: LiveData<AforoModel> = _aforo

    fun sumar() {
        val n = _aforo.value?.aforo ?: 0
        _aforo.value = AforoModel((n + 1).coerceAtMost(max))
    }

    fun restar() {
        val n = _aforo.value?.aforo ?: 0
        _aforo.value = AforoModel((n - 1).coerceAtLeast(0))
    }

    fun reiniciar() {
        _aforo.value = AforoProvider.inicial()
    }

    fun esComplet() = (_aforo.value?.aforo ?: 0) >= max
}