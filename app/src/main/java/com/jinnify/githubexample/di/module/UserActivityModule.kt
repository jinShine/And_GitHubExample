package com.jinnify.githubexample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jinnify.githubexample.ui.user.UserActivity
import com.jinnify.githubexample.ViewModelFactory
import com.jinnify.githubexample.di.key.ViewModelKey
import com.jinnify.githubexample.di.scope.PerActivity
import com.jinnify.githubexample.ui.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface UserActivityModule {

    @Binds
    @PerActivity
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @PerActivity
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    fun bindUserViewModel(userViewModel: UserViewModel): ViewModel

}
