package com.jinnify.githubexample.ui.user

import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jinnify.githubexample.R
import com.jinnify.githubexample.utility.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_user.*
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


        recyclerView.adapter = 
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}
