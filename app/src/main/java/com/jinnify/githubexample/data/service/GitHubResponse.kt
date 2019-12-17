package com.jinnify.githubexample.data.service

import com.jinnify.githubexample.data.model.User
import com.jinnify.githubexample.data.repository.GitHubError

sealed class GitHubResponse {
    data class Failure(val error: GitHubError) : GitHubResponse()
    data class Success(val data: List<User>) : GitHubResponse()
}
