package com.oman.forward.wanandroid.entity

data class SearchResultResponse(val curPage: Int,
                                val datas: List<Article>,
                                val offset: Int,
                                val over: Boolean,
                                val pageCount: Int,
                                val size: Int,
                                val total: Int)

data class Article(
        val author: String?,
        val chapterId: String? = "",
        val chapterName: String? = "",
        val collect: Boolean = false,
        val courseId: Int = 1,
        val id: Int = 1,
        val link: String = "",
        val niceDate: String = "",
        val niceShareDate: String = "",
        val publishTime: String = "",
        val shareDate: String = "",
        val shareUser: String = "",
        val superChapterId: String = "",
        val superChapterName: String = "",
        val title: String = "",
        val userId: String = ""
)