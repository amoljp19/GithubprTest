package com.softaai.githubprtest.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.persistence.room.Room
import android.support.v7.app.AppCompatActivity
import com.softaai.githubprtest.db.AppDatabase
import com.softaai.githubprtest.issues.viewmodels.IssuesListViewModel


/**
 * Created by Amol Pawar on 01-03-2019.
 * softAai Apps
 */

class ViewModelFactory(private val activity: AppCompatActivity): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(IssuesListViewModel::class.java)) {
            val db = Room.databaseBuilder(activity.applicationContext, AppDatabase::class.java, "issues").build()
            @Suppress("UNCHECKED_CAST")
            return IssuesListViewModel(db.issuesDao()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}