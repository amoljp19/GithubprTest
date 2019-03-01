package com.softaai.githubprtest.di

import com.softaai.githubprtest.issues.viewmodels.IssuesListViewModel
import dagger.Component
import javax.inject.Singleton


/**
 * Created by Amol Pawar on 28-02-2019.
 * softAai Apps
 */

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(issuesListViewModel: IssuesListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}