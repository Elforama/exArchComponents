package com.oneguygames.exarchcomponents

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

/**
 * Created by Jonathan Muller on 10/27/17.
 */
@Database(entities = arrayOf(User::class), version = 1)
abstract class Database: RoomDatabase() {
    abstract fun userDao(): UserDAO
}