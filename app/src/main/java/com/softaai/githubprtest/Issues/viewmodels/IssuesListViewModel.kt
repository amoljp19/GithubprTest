package com.softaai.githubprtest.Issues.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.softaai.githubprtest.network.GithubIssuesApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Amol Pawar on 28-02-2019.
 * softAai Apps
 */

class IssuesListViewModel : ViewModel(){

    @Inject
    lateinit var gitHubIssuesApi: GithubIssuesApi

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init{
        loadIssues()
    }

    private fun loadIssues(){
        subscription = gitHubIssuesApi.getIssues("prestodb", "presto", "open")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveIssuesListStart() }
            .doOnTerminate { onRetrieveIssuesListFinish() }
            .subscribe(
                { onRetrieveIssuesListSuccess() },
                { onRetrieveIssuesListError() }
            )
    }


    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onRetrieveIssuesListStart(){

    }

    private fun onRetrieveIssuesListFinish(){

    }

    private fun onRetrieveIssuesListSuccess(){

    }

    private fun onRetrieveIssuesListError(){

    }
}