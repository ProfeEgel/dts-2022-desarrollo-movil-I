package com.example.roomdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room

class MainActivity : AppCompatActivity() {
    private lateinit var db: GameDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Room.databaseBuilder(
            applicationContext,
            GameDatabase::class.java, "quizapp")
            .allowMainThreadQueries()
            .build()

        val userDao = db.userDao()
        //userDao.AddUser(User(78, "Juan", "Perez"))
        //userDao.AddUser(User(32, "Manuel", "Vazquez"))
        //userDao.AddUsers(User(45, "Javier", "Martinez"),
        //                 User(17, "Lucia", "Mendez"))

        //val user = User(78, "Juan", "Perez")
        //user.lastName = "Torres"
        //userDao.UpdateUser(user)

        val users = userDao.GetUsers()
    }
}
