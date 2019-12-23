package com.jinnify.githubexample.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide.init
import com.jinnify.githubexample.data.model.User
import com.jinnify.githubexample.data.repository.GitHubRepository
import com.jinnify.githubexample.data.service.GitHubResponse

import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val repository: GitHubRepository
) : ViewModel() {

    private val _userListLiveData = MutableLiveData<List<User>>()
    val userListLiveData: LiveData<List<User>> = _userListLiveData

    private val _isSwipeRefresh = MutableLiveData<Boolean>()
    val isSwipeRefresh: LiveData<Boolean> = _isSwipeRefresh

    init {
        getUsers()
    }

    private fun getUsers() {
        repository.getUsers { response ->
            when (response) {
                is GitHubResponse.Success -> {
                    println("${response.data}")
                    _userListLiveData.value = response.data
                }
                is GitHubResponse.Failure -> {
                    println("")
//                    _userListLiveData.value = response.error
                }
            }
        }
    }

    fun refresh() {
        getUsers()
        _isSwipeRefresh.value = false
    }
}

