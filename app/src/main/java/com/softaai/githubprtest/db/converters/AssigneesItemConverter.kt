package com.softaai.githubprtest.db.converters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.softaai.githubprtest.model.AssigneesItem


/**
 * Created by Amol Pawar on 01-03-2019.
 * softAai Apps
 */

class AssigneesItemConverter {

        @TypeConverter
        fun fromString(value: String): ArrayList<AssigneesItem> {
            val listType = object : TypeToken<ArrayList<AssigneesItem>>() {

            }.type
            return Gson().fromJson(value, listType)
        }

        @TypeConverter
        fun fromAssigneesItem(list: ArrayList<AssigneesItem>): String {
            val gson = Gson()
            val json = gson.toJson(list)
            return json
        }
    }
