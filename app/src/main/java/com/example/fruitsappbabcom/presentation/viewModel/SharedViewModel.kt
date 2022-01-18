package com.example.fruitsappbabcom.presentation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fruitsappbabcom.data.Fruit

class SharedViewModel : ViewModel() {
    val selectedItem = MutableLiveData<Fruit?>()
    fun select(fruit: Fruit?) {
        selectedItem.value = fruit
    }
}