package com.example.caloriecounter

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "calorie_table")
class Calories (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val foodItem: String,
    val calories: Int
    )