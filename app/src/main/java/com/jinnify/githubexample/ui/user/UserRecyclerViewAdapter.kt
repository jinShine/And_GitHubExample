package com.jinnify.githubexample.ui.user

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jinnify.githubexample.R
import com.jinnify.githubexample.data.model.User
import com.jinnify.githubexample.ui.user.viewholder.UserViewHolder

class UserRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_USER = R.layout.viewholder_user
    }

    private val userList = mutableListOf<User>()

    fun setUsers(list: List<User>) {
        userList.clear()
        userList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(VIEW_TYPE_USER, parent, false)

        return UserViewHolder(view)
    }

    override fun getItemCount() = userList.count()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is UserViewHolder -> holder.bind(userList[position])
        }
    }

}
