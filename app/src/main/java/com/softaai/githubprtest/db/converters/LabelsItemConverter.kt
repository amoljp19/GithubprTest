package com.softaai.githubprtest.db.converters

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.softaai.githubprtest.model.LabelsItem


/**
 * Created by Amol Pawar on 01-03-2019.
 * softAai Apps
 */
class LabelsItemConverter {

    @TypeConverter
    fun fromString(value: String): ArrayList<LabelsItem> {
        val listType = object : TypeToken<ArrayList<LabelsItem>>() {

        }.type
        return Gson().fromJson(value, listType)
    }

    @TypeConverter
    fun fromLabelsItem(list: ArrayList<LabelsItem>): String {
        val gson = Gson()
        val json = gson.toJson(list)
        return json
    }

}