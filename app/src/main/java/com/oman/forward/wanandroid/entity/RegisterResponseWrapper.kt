package com.oman.forward.wanandroid.entity

/**
 * {
 *  "data": {
 *  "admin": false,
 *  "chapterTops": [],
 *  "collectIds": [],
 *  "email": "",
 *  "icon": "",
 *  "id": 68581,
 *  "nickname": "test1234cq",
 *  "password": "",
 *  "publicName": "test1234cq",
 *  "token": "",
 *  "type": 0,
 *  "username": "test1234cq"
 *  },
 *  "errorCode": 0,
 *  "errorMsg": ""
 *  }
 */
data class RegisterResponseWrapper<T>(val data: T,
                                      val errorCode: String?,
                                      val errorMsg: String?
)