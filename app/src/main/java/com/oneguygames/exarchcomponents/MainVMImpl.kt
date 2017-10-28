package com.oneguygames.exarchcomponents

/**
 * Created by Jonathan Muller on 10/27/17.
 */
class MainVMImpl constructor(private val interactor: MainInteractor): MainVM {

    override fun users() = interactor.users()

    override fun createUser(firstName: String, lastName: String) {
        interactor.createUser(User(0, firstName, lastName))
    }
}