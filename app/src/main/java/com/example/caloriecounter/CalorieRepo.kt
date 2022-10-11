package com.example.caloriecounter

import androidx.lifecycle.LiveData

class CalorieRepo (private val calorieDao: CalorieDao) {

    val readAll: LiveData<List<Calories>> = calorieDao.readAll()

    suspend fun addFood(foodItem: Calories){
        calorieDao.addFood(foodItem)
    }

}