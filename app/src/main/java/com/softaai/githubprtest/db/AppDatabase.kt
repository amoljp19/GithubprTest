package com.softaai.githubprtest.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.softaai.githubprtest.db.DAO.IssuesDao
import com.softaai.githubprtest.db.converters.*
import com.softaai.githubprtest.model.IssuesResponse


/**
 * Created by Amol Pawar on 01-03-2019.
 * softAai Apps
 */

@Database(entities = arrayOf(IssuesResponse::class), version = 1)
@TypeConverters(PullRequestConverter::class, LabelsItemConverter::class, UserConverter::class,
     AssigneeConverter::class, AssigneesItemConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun issuesDao(): IssuesDao
}
