package com.jinnify.data.repository

import com.jinnify.data.model.User
import retrofit2.Call

interface GitHubRepository {

    fun fetchUser(): Call<List<User>>
}
