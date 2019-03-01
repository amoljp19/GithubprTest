package com.softaai.githubprtest.utils.extensions

import android.content.ContextWrapper
import android.support.v7.app.AppCompatActivity
import android.view.View


/**
 * Created by Amol Pawar on 28-02-2019.
 * softAai Apps
 */

fun View.getParentActivity(): AppCompatActivity?{
    var context = this.context
    while (context is ContextWrapper) {
        if (context is AppCompatActivity) {
            return context
        }
        context = context.baseContext
    }
    return null
}