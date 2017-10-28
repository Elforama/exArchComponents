package com.oneguygames.exarchcomponents

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.Observer
import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.user_list_item.view.*

/**
 * Created by Jonathan Muller on 10/27/17.
 */
class MainView constructor(context: Context,
                           parent: ViewGroup?,
                           lifecycleOwner: LifecycleOwner,
                           vm: MainVM) {

    val root = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false)

    init {
        val userAdapter = UserAdapter()
        root.recyclerView.apply {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(context)
        }

        root.createButton.setOnClickListener {
            vm.createUser(root.firstName.text.toString(),
                          root.lastName.text.toString())
        }

        vm.users().observe(lifecycleOwner, Observer<List<User>> {
            it?.run { userAdapter.users = it.reversed() }
        })
    }

}

class UserViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    companion object {
        const val LAYOUT_ID = R.layout.user_list_item
    }

    fun bindUser(user: User) {
        itemView.textView.text = "${user.lastName}, ${user.firstName}"
    }
}

class UserAdapter : RecyclerView.Adapter<UserViewHolder>() {

    var users = listOf<User>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(UserViewHolder.LAYOUT_ID, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bindUser(users[position])
    }

    override fun getItemCount() = users.size
}