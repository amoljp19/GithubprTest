package com.softaai.githubprtest.network

import com.softaai.githubprtest.model.IssuesResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * Created by Amol Pawar on 28-02-2019.
 * softAai Apps
 */
interface GithubIssuesApi {
    @GET("/{ORG_NAME}/{REPO_NAME}/issues")
    fun getOpenIssues(@Path("ORG_NAME") ORG_NAME : String, @Path("REPO_NAME") REPO_NAME : String , @Query("state") state : String ): Observable<List<IssuesResponse>>

    @GET("/{ORG_NAME}/{REPO_NAME}/issues")
    fun getClosedIssues(@Path("ORG_NAME") ORG_NAME : String, @Path("REPO_NAME") REPO_NAME : String , @Query("state") state : String): Observable<List<IssuesResponse>>


    @GET("/{ORG_NAME}/{REPO_NAME}/issues")
    fun getIssues(@Path("ORG_NAME") ORG_NAME : String, @Path("REPO_NAME") REPO_NAME : String , @Query("state") state : String): Observable<List<IssuesResponse>>
}