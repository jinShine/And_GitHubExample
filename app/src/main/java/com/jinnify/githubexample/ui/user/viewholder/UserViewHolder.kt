package com.jinnify.githubexample.ui.user.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jinnify.githubexample.data.model.User
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.viewholder_user.view.*

class UserViewHolder(
    override val containerView: View
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    companion object {
        const val USER_IMAGE_SIZE = 60
    }

    fun bind(item: User) {

        with(containerView) {
            println("${item}")

            Glide.with(this)
                .load(item.avatarUrl)
                .override(USER_IMAGE_SIZE)
                .into(userImageView)

            userID.text = "${item.id}"
            userName.text = item.login
        }
    }
}
