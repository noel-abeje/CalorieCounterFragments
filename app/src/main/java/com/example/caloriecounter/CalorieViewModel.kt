package com.example.caloriecounter

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CalorieViewModel(application: Application): AndroidViewModel(application) {

    val readAll: LiveData<List<Calories>>
    private val repository: CalorieRepo

    init {
        val calorieDao = CalorieDatabase.getDatabase(application).calorieDao()
        repository = CalorieRepo(calorieDao)
        readAll = repository.readAll
    }

    fun addFood(foodItem: Calories) {
        viewModelScope.launch (Dispatchers.IO){
            repository.addFood(foodItem)
        }
    }

}