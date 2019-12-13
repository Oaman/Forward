package com.oman.forward

import com.oman.forward.db.entity.AppEntity
import com.oman.forward.db.entity.CommentEntity

class TestData {
    companion object {
        internal val APP_ENTITY1 = AppEntity("com.test.example1",
                1, "1", "label1", "versionName1",
                "this is description of Example1", "icon1")

        internal val APP_ENTITY2 = AppEntity("com.test.example2",
                2, "2", "label2", "versionName2",
                "this is description of Example2", "icon2")

        internal val APPS = listOf(APP_ENTITY1, APP_ENTITY2)


        internal val COMMENT_ENTITY1 = CommentEntity(packageName = "com.test.example1")

        internal val COMMENT_ENTITY2 = CommentEntity(packageName = "com.test.example2")

        internal val COMMENTS = listOf(COMMENT_ENTITY1, COMMENT_ENTITY2)


    }
}