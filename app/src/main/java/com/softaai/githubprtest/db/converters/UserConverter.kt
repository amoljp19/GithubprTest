package com.softaai.githubprtest.db.converters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.softaai.githubprtest.model.User


/**
 * Created by Amol Pawar on 01-03-2019.
 * softAai Apps
 */

class UserConverter {
    @TypeConverter
    fun fromString(value: String): User {
        val listType = object : TypeToken<User>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromUser(user: User): String {
        val gson = Gson()
        val json = gson.toJson(user)
        return json
    }
}