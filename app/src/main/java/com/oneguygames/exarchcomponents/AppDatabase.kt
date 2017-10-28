package com.oneguygames.exarchcomponents

import android.arch.persistence.room.Room

/**
 * Created by Jonathan Muller on 10/27/17.
 */
object AppDatabase {

    val db: Database by lazy { Room.databaseBuilder(App.context(), Database::class.java, "db").build() }
}