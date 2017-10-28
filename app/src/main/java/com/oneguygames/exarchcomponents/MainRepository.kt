package com.oneguygames.exarchcomponents

import io.reactivex.Flowable

/**
 * Created by Jonathan Muller on 10/27/17.
 */
interface MainRepository {

    fun users(): Flowable<List<User>>
    fun removeUser(user: User)
    fun addUser(user: User)
}