package com.jinnify.githubexample.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jinnify.githubexample.di.key.ViewModelKey
import com.jinnify.githubexample.di.scope.PerActivity
import com.jinnify.githubexample.ui.detail.DetailViewModel
import com.jinnify.githubexample.utility.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface DetailActivityModule {

    @Binds
    @PerActivity
    fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @PerActivity
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    fun bindDetailViewModel(viewModel: DetailViewModel): ViewModel
}
