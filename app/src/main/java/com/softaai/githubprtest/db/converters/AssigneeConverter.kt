package com.softaai.githubprtest.db.converters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.softaai.githubprtest.model.Assignee
import com.softaai.githubprtest.model.AssigneesItem
import com.softaai.githubprtest.model.LabelsItem
import com.softaai.githubprtest.model.User


/**
 * Created by Amol Pawar on 01-03-2019.
 * softAai Apps
 */

class AssigneeConverter{

    @TypeConverter
    fun fromString(value: String): Assignee {
        val listType = object : TypeToken<Assignee>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromAssignee(assignee: Assignee): String {
        val gson = Gson()
        val json = gson.toJson(assignee)
        return json
    }
}