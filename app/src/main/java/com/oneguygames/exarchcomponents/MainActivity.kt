package com.oneguygames.exarchcomponents

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        async(UI) {
            Log.d("TEST", "Enter async")
            val result = bg {
                Log.d("TEST", "Enter bg")
                AppDatabase.db.userDao().insert(User(0,"Jonathan", "Muller"))
                AppDatabase.db.userDao().insert(User(0,"Amy", "Muller"))
                Log.d("TEST", "Exit bg")
                AppDatabase.db.userDao().getAllUsers()
            }

            result.await().observe(this@MainActivity, Observer<List<User>> {
                Log.d("TEST", "Got user data")
                text.text = it?.get(0)?.firstName?: "NOT FOUND"
            })
            Log.d("TEST", "Exit async")
        }
    }
}
