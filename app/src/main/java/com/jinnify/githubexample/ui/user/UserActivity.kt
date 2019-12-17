package com.jinnify.githubexample.ui.user

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.jinnify.githubexample.R
import com.jinnify.githubexample.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class UserActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val viewModel = ViewModelProviders
            .of(this, viewModelFactory)
            .get(UserViewModel::class.java)

        println(" : ")

        viewModel.fetchUser()
    }
}
