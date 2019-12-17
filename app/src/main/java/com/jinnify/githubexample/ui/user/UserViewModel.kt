package com.jinnify.githubexample.ui.user

import androidx.lifecycle.ViewModel
import com.jinnify.data.model.User
import com.jinnify.data.repository.GitHubRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val repository: GitHubRepository
): ViewModel() {

    fun fetchUser() {
        println("ViewModel")

        repository.fetchUser().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                println(" ${t.message}")
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                println(" ${response.body()}")
            }

        })
    }
}

