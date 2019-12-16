package com.jinnify.githubexample.di.module

import com.jinnify.githubexample.ui.user.UserActivity
import com.jinnify.githubexample.di.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [UserActivityModule::class])
    abstract fun userActivity(): UserActivity
}
