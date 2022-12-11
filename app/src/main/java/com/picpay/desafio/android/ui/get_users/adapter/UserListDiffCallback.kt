package com.picpay.desafio.android.ui.get_users.adapter

import androidx.recyclerview.widget.DiffUtil
import com.picpay.desafio.android.ui.model.User

val USER_DIFF_UTIL_CALLBACK = object : DiffUtil.ItemCallback<User>() {
    override fun areItemsTheSame(oldItem: User, newItem: User): Boolean =
        oldItem.username == newItem.username
    override fun areContentsTheSame(oldItem: User, newItem: User): Boolean =
        oldItem == newItem
}