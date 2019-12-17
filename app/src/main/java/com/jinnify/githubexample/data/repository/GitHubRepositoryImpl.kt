package com.jinnify.githubexample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jinnify.githubexample.data.model.User
import com.jinnify.githubexample.data.service.GitHubApiService
import com.jinnify.githubexample.data.service.GitHubResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import kotlin.concurrent.thread

class GitHubRepositoryImpl @Inject constructor(
    private val gitHubApiService: GitHubApiService
) : GitHubRepository {

    private val _userListLiveData = MutableLiveData<GitHubResponse>()
    override fun userListLiveData(): LiveData<GitHubResponse> = _userListLiveData

    init {
        thread {
            Thread.sleep(500L)
            gitHubApiService.fetchUser().enqueue(object : Callback<List<User>> {
                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    _userListLiveData.postValue(GitHubResponse.Failure(GitHubError.NETWORK))
                }

                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    response.body()?.let {
                        _userListLiveData.postValue(GitHubResponse.Success(it))
                    } ?: run {
                        _userListLiveData.postValue(GitHubResponse.Failure(GitHubError.EMPTY))
                    }
                }

            })
        }
    }
}
