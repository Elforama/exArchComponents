package com.oneguygames.exarchcomponents

import android.arch.lifecycle.LiveData

/**
 * Created by Jonathan Muller on 10/27/17.
 */
interface MainInteractor {

    fun users(): LiveData<List<User>>

    fun createUser(user: User)
}