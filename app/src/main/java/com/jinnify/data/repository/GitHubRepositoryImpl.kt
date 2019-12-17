package com.jinnify.data.repository

import com.jinnify.data.Service.GitHubApiService
import com.jinnify.githubexample.di.module.NetworkModule
import javax.inject.Inject

class GitHubRepositoryImpl @Inject constructor(
    private val gitHubApiService: GitHubApiService
) : GitHubRepository {

    override fun fetchUser() = gitHubApiService.fetchUser()
}
