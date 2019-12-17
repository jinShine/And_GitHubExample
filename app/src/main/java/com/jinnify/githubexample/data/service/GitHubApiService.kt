package com.jinnify.githubexample.data.service

import com.jinnify.githubexample.data.model.User
import retrofit2.Call
import retrofit2.http.GET

interface GitHubApiService {

    @GET(value = "users")
    fun fetchUser(): Call<List<User>>
}
