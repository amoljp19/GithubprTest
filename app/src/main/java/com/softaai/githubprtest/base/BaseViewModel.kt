package com.softaai.githubprtest.base

import android.arch.lifecycle.ViewModel
import com.softaai.githubprtest.di.DaggerViewModelInjector
import com.softaai.githubprtest.di.NetworkModule
import com.softaai.githubprtest.di.ViewModelInjector
import com.softaai.githubprtest.issues.viewmodels.IssuesListViewModel


/**
 * Created by Amol Pawar on 28-02-2019.
 * softAai Apps
 */

abstract class BaseViewModel: ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is IssuesListViewModel -> injector.inject(this)
        }
    }
}