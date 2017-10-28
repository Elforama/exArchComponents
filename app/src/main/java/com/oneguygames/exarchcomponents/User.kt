package com.oneguygames.exarchcomponents

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by Jonathan Muller on 10/27/17.
 */
@Entity(tableName = "users")
data class User(@PrimaryKey(autoGenerate = true)
                val uid: Long,
                @ColumnInfo(name = "first_name")
                val firstName: String,
                @ColumnInfo(name = "last_name")
                val lastName: String)