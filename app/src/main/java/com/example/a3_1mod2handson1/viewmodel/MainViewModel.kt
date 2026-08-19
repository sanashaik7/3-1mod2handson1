package com.example.a3_1mod2handson1.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a3_1mod2handson1.repository.AIRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val repository = AIRepository()

    val response = MutableLiveData<String>()

    val loading = MutableLiveData(false)

    fun askAI(prompt: String) {
        loading.value = true
        viewModelScope.launch {
            response.value = repository.askAI(prompt)
            loading.value = false
        }
    }
}
