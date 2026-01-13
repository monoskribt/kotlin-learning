package com.example.mobile_app.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mobile_app.data.User

@Dao
interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM users WHERE login = :login AND password = :password")
    suspend fun login(login: String, password: String): User?
}