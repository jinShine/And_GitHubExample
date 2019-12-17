package com.jinnify.githubexample.data.repository

import androidx.lifecycle.LiveData
import com.jinnify.githubexample.data.service.GitHubResponse

interface GitHubRepository {

    fun userListLiveData(): LiveData<GitHubResponse>
}
