package com.jinnify.githubexample.data.repository

import android.provider.SyncStateContract.Helpers.update
import com.jinnify.githubexample.data.model.User
import com.jinnify.githubexample.data.service.GitHubApiService
import com.jinnify.githubexample.data.service.GitHubResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val gitHubApiService: GitHubApiService
) : GitHubRepository {

    private var cachedUserList = mutableListOf<User>()

    override fun getUsers(completion: (GitHubResponse) -> Unit) {

        if (cachedUserList.isNotEmpty()) {
            completion.invoke(GitHubResponse.Success(cachedUserList))
        }

        gitHubApiService.fetchUser().enqueue(object : Callback<List<User>> {
            override fun onFailure(call: Call<List<User>>, t: Throwable) {
                completion.invoke(GitHubResponse.Failure(GitHubError.NETWORK))
            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                response.body()?.let {
                    updateUsers(it)
                    completion.invoke(GitHubResponse.Success(it))
                }
            }
        })
    }

    private fun updateUsers(list: List<User>) {
        cachedUserList.clear()
        cachedUserList.addAll(list)
    }
}
