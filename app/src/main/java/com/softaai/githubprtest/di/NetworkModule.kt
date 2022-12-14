package com.softaai.githubprtest.di

import com.softaai.githubprtest.issues.adapters.IssueListAdapter
import com.softaai.githubprtest.network.GithubIssuesApi
import com.softaai.githubprtest.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * Created by Amol Pawar on 28-02-2019.
 * softAai Apps
 */

@Module
@Suppress("unused")
object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun providePostApi(retrofit: Retrofit): GithubIssuesApi {
        return retrofit.create(GithubIssuesApi::class.java)
    }


    @Provides
    @Reusable
    @JvmStatic
    internal fun provideIssueListAdapter(): IssueListAdapter {
        return IssueListAdapter()
    }


    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}