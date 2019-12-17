package com.jinnify.githubexample.ui.user

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.jinnify.githubexample.R
import com.jinnify.githubexample.utility.ViewModelFactory
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

        viewModel.userListLiveData.observe(
            this, Observer {
                println("${it}")
            }
        )
    }
}
