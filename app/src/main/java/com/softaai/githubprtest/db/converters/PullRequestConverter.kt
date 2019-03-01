package com.softaai.githubprtest.db.converters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.softaai.githubprtest.model.PullRequest


/**
 * Created by Amol Pawar on 01-03-2019.
 * softAai Apps
 */

class PullRequestConverter {

    @TypeConverter
    fun fromString(value: String): PullRequest {
        val listType = object : TypeToken<PullRequest>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromPullRequest(pullRequest: PullRequest): String {
        val gson = Gson()
        val json = gson.toJson(pullRequest)
        return json
    }
}