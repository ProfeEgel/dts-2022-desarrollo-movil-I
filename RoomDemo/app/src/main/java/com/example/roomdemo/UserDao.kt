package com.example.roomdemo

import androidx.room.*

data class FullName(
    @ColumnInfo(name = "last_name") val lastName: String?,
    @ColumnInfo(name = "first_name") val firstName: String?)

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE id >= :minId AND id <= :maxId")
    fun GetUsers(minId: Int, maxId: Int): List<User>

    @Query("SELECT * FROM users WHERE id IN (:ids)")
    fun GetUsers(ids: List<Int>): List<User>

    @Query("SELECT * FROM users ORDER BY last_name, first_name")
    fun GetUsers(): List<User>

    @Query("SELECT * FROM users WHERE id = :id")
    fun GetUser(id: Int): User

    @Query("SELECT last_name FROM users WHERE id = :id")
    fun GetUserLastName(id: Int): String

    @Query("SELECT last_name, first_name FROM users WHERE id = :id")
    fun GetUserFullName(id: Int): FullName

    @Query("SELECT last_name, first_name FROM users")
    fun GetUsersFullName(): List<FullName>





    @Insert
    fun AddUser(user: User)
    @Insert
    fun AddUsers(vararg users: User)
    @Insert
    fun AddUsers(users: List<User>)

    @Update
    fun UpdateUser(user: User)
    @Update
    fun UpdateUsers(vararg users: User)
    @Update
    fun UpdateUsers(users: List<User>)

    @Delete
    fun DeleteUser(user: User)
    @Delete
    fun DeleteUsers(vararg users: User)
    @Delete
    fun DeleteUsers(users: List<User>)
}
