package com.example.fruitsappbabcom.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fruitsappbabcom.data.FruitsList
import com.example.fruitsappbabcom.model.FruitApiService
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    private val _items = MutableLiveData<FruitsList>()
    val items : LiveData<FruitsList> get() = _items
    init {
        viewModelScope.launch {
            _items.value = FruitApiService.getFruitsService()
        }
    }

}