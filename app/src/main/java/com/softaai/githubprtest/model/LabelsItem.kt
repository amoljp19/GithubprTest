package com.softaai.githubprtest.model

import com.squareup.moshi.Json

data class LabelsItem(@Json(name = "default")
                      val default: Boolean = false,
                      @Json(name = "color")
                      val color: String = "",
                      @Json(name = "name")
                      val name: String = "",
                      @Json(name = "id")
                      val id: Int = 0,
                      @Json(name = "url")
                      val url: String = "",
                      @Json(name = "node_id")
                      val nodeId: String = "")