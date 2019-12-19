package com.jinnify.githubexample.ui.user

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.jinnify.githubexample.R
import com.jinnify.githubexample.utility.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_user.*
import javax.inject.Inject

class UserActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private val viewModel: UserViewModel by lazy {
        ViewModelProviders
            .of(this, viewModelFactory)
            .get(UserViewModel::class.java)
    }

    private val adapter = UserRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        configureRecyclerView()
        eventBinding()

    }

    private fun configureRecyclerView() {
        recyclerView.adapter = adapter

        //xml에 대체로 가능
        //app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        recyclerView.layoutManager = LinearLayoutManager(this)
    }


    private fun eventBinding() {

        viewModel.userListLiveData.observe(
            this, Observer {
                adapter.setUsers(it)
            }
        )

        viewModel.isSwipeRefresh.observe(
            this, Observer {
                swipeRefresh.isRefreshing = it
            }
        )

        swipeRefresh.setOnRefreshListener {  viewModel.refresh() }
    }
}
