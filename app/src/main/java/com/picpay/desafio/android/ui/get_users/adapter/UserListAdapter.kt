package com.picpay.desafio.android.ui.get_users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.picpay.desafio.android.databinding.ListItemUserBinding
import com.picpay.desafio.android.ui.model.User

class UserListAdapter :
    ListAdapter<User, UserListItemViewHolder>(USER_DIFF_UTIL_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder =
        UserListItemViewHolder(
            ListItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )


    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) =
        holder.bind(getItem(position))
}