package com.softaai.githubprtest.issues.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.softaai.githubprtest.base.BaseViewModel
import com.softaai.githubprtest.model.IssuesResponse


/**
 * Created by Amol Pawar on 28-02-2019.
 * softAai Apps
 */

class IssueViewModel: BaseViewModel() {
    private val issuePrNumber = MutableLiveData<String>()
    private val issueTitle = MutableLiveData<String>()
    private val issueUser = MutableLiveData<String>()
    private val issuePatchUrl = MutableLiveData<String>()


    fun bind(issues: IssuesResponse){
        issuePrNumber.value = issues.number.toString()
        issueTitle.value = issues.title
        issueUser.value = issues.user.login
        issuePatchUrl.value = issues.pullRequest.patchUrl
    }

    fun getIssuePrNumber():MutableLiveData<String>{
        return issuePrNumber
    }

    fun getIssueTitle():MutableLiveData<String>{
        return issueTitle
    }

    fun getIssueUser():MutableLiveData<String>{
        return issueUser
    }



    fun getIssuePatchUrl():MutableLiveData<String>{
        return issuePatchUrl
    }

}