package com.oman.forward.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

/**

 * @author:ZhouJiang
 * @date:2019/11/26 23:08
 * @email:zhoujiang2012@163.com

 */
@Entity(tableName = "comments",
        foreignKeys = [
            ForeignKey(entity = AppEntity::class,
                    parentColumns = ["packageName"],
                    childColumns = ["packageName"],
                    onDelete = ForeignKey.CASCADE)
        ],
        indices = [Index("packageName")])
class CommentEntity(@PrimaryKey(autoGenerate = true) val id: Int = 0,
                    val packageName: String,
                    val comment: String = "this is comment for $packageName")