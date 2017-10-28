package com.oneguygames.exarchcomponents

import android.util.Log
import io.reactivex.Flowable
import io.reactivex.internal.operators.completable.CompletableFromAction
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jonathan Muller on 10/28/17.
 */
class MainRepositoryImpl : MainRepository {

    override fun users(): Flowable<List<User>> {
        return AppDatabase.db.userDao().getAllUsers()
    }

    override fun removeUser(user: User) {
        AppDatabase.db.userDao().delete(user)
    }

    override fun addUser(user: User) {
        CompletableFromAction {
            AppDatabase.db.userDao().insert(user)
        }.subscribeOn(Schedulers.io())
                .subscribe {
                    Log.d("TEST", "Created user")
                }
    }
}