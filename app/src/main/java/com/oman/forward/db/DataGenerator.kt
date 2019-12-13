package com.oman.forward.db

import com.oman.forward.db.entity.AppEntity
import com.oman.forward.db.entity.CommentEntity

object DataGenerator {
    fun getApps(): List<AppEntity> {
        val apps = mutableListOf<AppEntity>()
        for (i in 1..20) {
            apps.add(AppEntity("com.test.example$i",
                    i, "$i", "label$i", "versionName$i",
                    "this is description of Example$i", "icon$i"))
        }
        return apps
    }

    fun getComments(apps: List<AppEntity>): List<CommentEntity> {
        val comments = mutableListOf<CommentEntity>()
        for (app in apps) {
            for (i in 1..3) {
                comments.add(CommentEntity(packageName = app.packageName,
                        comment = "this is the $i comment for ${app.versionLabel}"))
            }
        }
        return comments
    }
}