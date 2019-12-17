package com.jinnify.githubexample.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.jinnify.githubexample.data.model.User
import com.jinnify.githubexample.data.repository.GitHubRepository
import com.jinnify.githubexample.data.service.GitHubResponse

import javax.inject.Inject

class UserViewModel @Inject constructor(
    private val repository: GitHubRepository
) : ViewModel() {

    private val _userListLiveData = MutableLiveData<List<User>>()
    val userListLiveData: LiveData<List<User>> = _userListLiveData

    private val liveDataManager = Observer<GitHubResponse> { response ->
        when (response) {
            is GitHubResponse.Success -> {
                _userListLiveData.value = response.data
            }
        }
    }

    init {
        repository.userListLiveData().observeForever(liveDataManager)
    }

}

