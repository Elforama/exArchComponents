package com.oneguygames.exarchcomponents

import android.arch.lifecycle.LiveData

/**
 * Created by Jonathan Muller on 10/27/17.
 */
interface MainVM {
    fun createUser(firstName: String, lastName: String)
    fun users(): LiveData<List<User>>
}