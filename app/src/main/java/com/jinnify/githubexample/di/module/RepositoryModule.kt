package com.jinnify.githubexample.di.module

import com.jinnify.githubexample.data.repository.GitHubRepository
import com.jinnify.githubexample.data.repository.GitHubRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun bindGitHubRepository(gitHubRepositoryImpl: GitHubRepositoryImpl): GitHubRepository
}
