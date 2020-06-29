package com.oman.forward.wanandroid.entity

/**
 *  "data": {
 *   "admin": false,
 *   "chapterTops": [],
 *   "collectIds": [],
 *   "email": "",
 *   "icon": "",
 *   "id": 68581,
 *   "nickname": "test1234cq",
 *   "password": "",
 *   "publicName": "test1234cq",
 *   "token": "",
 *   "type": 0,
 *   "username": "test1234cq"
 *  }
 */
data class LoginRegisterResponse(val admin: Boolean,
                                 val chapterTops: List<*>,
                                 val collectIds: List<*>,
                                 val email: String?,
                                 val icon: String?,
                                 val id: String?,
                                 val nickname: String?,
                                 val password: String?,
                                 val publicName: String?,
                                 val token: String?,
                                 val type: String?,
                                 val username: String?

)