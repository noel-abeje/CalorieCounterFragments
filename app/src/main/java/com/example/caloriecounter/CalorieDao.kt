package com.example.caloriecounter

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CalorieDao {

    @Insert
    suspend fun addFood(foodItem: Calories)

    @Query("Select * From calorie_table Order By id Asc")
    fun readAll(): LiveData<List<Calories>>

}