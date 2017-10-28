package com.oneguygames.exarchcomponents

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jonathan Muller on 10/28/17.
 */
class MainInteractorImpl constructor(private val repository: MainRepository): MainInteractor {

    private val userLiveData: LiveData<List<User>> = LiveDataReactiveStreams
            .fromPublisher(repository.users()
                                       .subscribeOn(Schedulers.io())
                                       .observeOn(AndroidSchedulers.mainThread()))

    override fun users(): LiveData<List<User>> {
        return userLiveData
    }

    override fun createUser(user: User) {
        repository.addUser(user)
    }
}