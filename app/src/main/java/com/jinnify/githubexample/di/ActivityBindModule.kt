package com.jinnify.githubexample.di

import com.jinnify.githubexample.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindModule {

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity
}
