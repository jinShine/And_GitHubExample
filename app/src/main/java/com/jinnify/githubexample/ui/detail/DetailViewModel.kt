package com.jinnify.githubexample.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jinnify.githubexample.data.model.User
import com.jinnify.githubexample.data.repository.GitHubRepository
import com.jinnify.githubexample.data.service.GitHubResponse
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val gitHubRepository: GitHubRepository
) : ViewModel() {

    private val _userLiveData = MutableLiveData<User>()
    val userLiveData: LiveData<User> = _userLiveData

    fun fetchUser(id: Int) {
        gitHubRepository.getUsers {
            when (it) {
                is GitHubResponse.Success ->  {
                    val user = it.data.firstOrNull { it.id == id }
                    user?.let {
                        _userLiveData.value = it
                    }
                }
            }
        }
    }

    fun randomUser() {
        gitHubRepository.getUsers {
            when (it) {
                is GitHubResponse.Success ->  {
                    it.data.shuffled().first().let {
                        _userLiveData.value = it
                    }
                }
            }
        }
    }
}
