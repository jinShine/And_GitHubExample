package com.jinnify.data.Service

import com.jinnify.data.model.User
import retrofit2.Call
import retrofit2.http.GET

interface GitHubApiService {

    @GET(value = "users")
    fun fetchUser(): Call<List<User>>
}
