package com.softaai.githubprtest.model

import com.squareup.moshi.Json

data class IssuesResponse(@Json(name = "pull_request")
                      val pullRequest: PullRequest,
                          @Json(name = "comments")
                      val comments: Int = 0,
                          @Json(name = "closed_at")
                      val closedAt: String = "",
                          @Json(name = "assignees")
                      val assignees: List<AssigneesItem>?,
                          @Json(name = "created_at")
                      val createdAt: String = "",
                          @Json(name = "title")
                      val title: String = "",
                          @Json(name = "body")
                      val body: String = "",
                          @Json(name = "url")
                      val url: String = "",
                          @Json(name = "labels")
                      val labels: List<LabelsItem>?,
                          @Json(name = "labels_url")
                      val labelsUrl: String = "",
                          @Json(name = "author_association")
                      val authorAssociation: String = "",
                          @Json(name = "number")
                      val number: Int = 0,
                          @Json(name = "milestone")
                      val milestone: String = "",
                          @Json(name = "updated_at")
                      val updatedAt: String = "",
                          @Json(name = "events_url")
                      val eventsUrl: String = "",
                          @Json(name = "html_url")
                      val htmlUrl: String = "",
                          @Json(name = "comments_url")
                      val commentsUrl: String = "",
                          @Json(name = "repository_url")
                      val repositoryUrl: String = "",
                          @Json(name = "id")
                      val id: Int = 0,
                          @Json(name = "state")
                      val state: String = "",
                          @Json(name = "assignee")
                      val assignee: Assignee,
                          @Json(name = "locked")
                      val locked: Boolean = false,
                          @Json(name = "user")
                      val user: User,
                          @Json(name = "node_id")
                      val nodeId: String = "")