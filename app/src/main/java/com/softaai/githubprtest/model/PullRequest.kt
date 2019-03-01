package com.softaai.githubprtest.model

import android.arch.persistence.room.Entity
import com.squareup.moshi.Json

@Entity
data class PullRequest(@Json(name = "patch_url")
                       val patchUrl: String = "",
                       @Json(name = "html_url")
                       val htmlUrl: String = "",
                       @Json(name = "diff_url")
                       val diffUrl: String = "",
                       @Json(name = "url")
                       val url: String = "")