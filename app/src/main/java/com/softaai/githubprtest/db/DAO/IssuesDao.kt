package com.softaai.githubprtest.db.DAO

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.softaai.githubprtest.model.IssuesResponse


/**
 * Created by Amol Pawar on 01-03-2019.
 * softAai Apps
 */

@Dao
interface IssuesDao {

        @get:Query("SELECT * FROM IssuesResponse")
        val all: List<IssuesResponse>

        @Insert
        fun insertAll(vararg issues: IssuesResponse)

}
