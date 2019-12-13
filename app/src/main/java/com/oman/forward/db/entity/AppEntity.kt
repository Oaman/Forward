package com.oman.forward.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**

 * @author:ZhouJiang
 * @date:2019/11/26 23:08
 * @email:zhoujiang2012@163.com

 */
@Entity(tableName = "apps")
data class AppEntity(
        @ColumnInfo(name = "packageName") @PrimaryKey val packageName: String,
        @ColumnInfo(name = "app_id") val id: Int,
        @ColumnInfo(name = "versionCode") val versionCode: String,
        @ColumnInfo(name = "versionLabel") val versionLabel: String,
        @ColumnInfo(name = "versionName") val versionName: String,
        @ColumnInfo(name = "description") val description: String,
        @ColumnInfo(name = "icon") val icon: String)