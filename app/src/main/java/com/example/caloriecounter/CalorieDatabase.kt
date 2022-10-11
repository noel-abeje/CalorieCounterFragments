package com.example.caloriecounter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Calories::class], version = 1, exportSchema = false)
abstract class CalorieDatabase: RoomDatabase() {

    abstract fun calorieDao(): CalorieDao

    companion object{
        @Volatile
        private var INSTANCE: CalorieDatabase? = null

        fun getDatabase(context: Context): CalorieDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CalorieDatabase::class.java,
                    "calorie_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}