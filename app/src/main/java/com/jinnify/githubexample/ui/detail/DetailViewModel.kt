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

    private val _errorLiveData = MutableLiveData<Error>()
    val errorLiveData: LiveData<Error> = _errorLiveData

    fun fetchUser(id: Int) {
        gitHubRepository.getUsers { response ->
            when (response) {
                is GitHubResponse.Success -> {
                    val user = response.data.firstOrNull { it.id == id }
                    user?.let { _userLiveData.value = it }
                }
                is GitHubResponse.Failure -> {
                    _errorLiveData.value = Error("네트워크 에러")
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
