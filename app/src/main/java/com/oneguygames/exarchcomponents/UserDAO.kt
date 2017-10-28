package com.oneguygames.exarchcomponents

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

/**
 * Created by Jonathan Muller on 10/27/17.
 */
@Dao
interface UserDAO {

    @Query("SELECT * FROM users")
    fun getAllUsers(): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE uid IN (:ids)")
    fun getAllUsersById(ids: IntArray): LiveData<List<User>>

    @Query("SELECT * FROM users WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): LiveData<User>

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}