package com.softaai.githubprtest.issues.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.softaai.githubprtest.issues.adapters.IssueListAdapter
import com.softaai.githubprtest.R
import com.softaai.githubprtest.base.BaseViewModel
import com.softaai.githubprtest.db.DAO.IssuesDao
import com.softaai.githubprtest.model.IssuesResponse
import com.softaai.githubprtest.network.GithubIssuesApi
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


/**
 * Created by Amol Pawar on 28-02-2019.
 * softAai Apps
 */

class IssuesListViewModel(private val issuesDao: IssuesDao) : BaseViewModel(){

    @Inject
    lateinit var gitHubIssuesApi: GithubIssuesApi

    var issueListAdapter: IssueListAdapter = IssueListAdapter()

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()




    val errorMessage:MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadIssues() }

    init{
        loadIssues()
    }

    fun loadIssues(){


        subscription = Observable.fromCallable { issuesDao.all }
            .concatMap {
                    dbIssuesResponseList ->
                if(dbIssuesResponseList.isEmpty())
                    gitHubIssuesApi.getIssues("prestodb", "presto", "open").concatMap {
                            apiIssuesResponseList -> issuesDao.insertAll(*apiIssuesResponseList.toTypedArray())
                        Observable.just(apiIssuesResponseList)
                    }
                else
                    Observable.just(dbIssuesResponseList)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveIssuesListStart() }
            .doOnTerminate { onRetrieveIssuesListFinish() }
            .subscribe(
                { result -> onRetrieveIssuesListSuccess(result) },
                { error -> onRetrieveIssuesListError(error) }
            )
    }


    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }

    private fun onRetrieveIssuesListStart(){
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveIssuesListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveIssuesListSuccess(issuesResponse: List<IssuesResponse>) {
        issueListAdapter.updateIssuesResponseList(issuesResponse)
        issueListAdapter.notifyDataSetChanged()
    }

    private fun onRetrieveIssuesListError(error: Throwable) {

        errorMessage.value = R.string.issues_error
    }

   
}