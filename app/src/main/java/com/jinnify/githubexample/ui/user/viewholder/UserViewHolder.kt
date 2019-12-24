package com.jinnify.githubexample.ui.user.viewholder

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jinnify.githubexample.data.model.User
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.viewholder_user.view.*

class UserViewHolder(
    override val containerView: View,
    private val onClick: (Int) -> Unit
) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(item: User) {
        with(containerView) {

            userID.text = "${item.id}"
            userName.text = item.login

            setOnClickListener {
                onClick(item.id)
            }
        }
    }
}

@BindingAdapter("imageSrc")
fun imageSrc(imageView: ImageView, url: String) {
    Glide.with(imageView)
        .load(url)
        .into(imageView)
}
