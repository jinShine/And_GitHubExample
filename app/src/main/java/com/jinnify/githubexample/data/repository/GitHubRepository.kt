package com.jinnify.githubexample.data.repository

import com.jinnify.githubexample.data.service.GitHubResponse

interface GitHubRepository {

    fun getUsers(completion: (GitHubResponse) -> Unit)
}
