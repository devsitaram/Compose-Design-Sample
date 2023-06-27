package com.sitaram.composedesign.features.database

import android.content.Context
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

abstract class DatabaseHelper : RoomDatabase() {

    // initialize the final variable
    private val DB_NAME: String = "UserDatabase"
    private var instance: DatabaseHelper? = null

    @Synchronized
    fun getDatabaseInstance(context: Context): DatabaseHelper? {
        if (instance == null) {
            // call the get Instance from room database
            instance = databaseBuilder(context, DatabaseHelper::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }

        // return the instance
        return instance
    }

    // create the abstract methods
    abstract fun userDao(): Dao
}
