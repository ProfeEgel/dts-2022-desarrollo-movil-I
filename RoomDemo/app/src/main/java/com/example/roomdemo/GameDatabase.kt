package com.example.roomdemo

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1)
abstract class GameDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}
