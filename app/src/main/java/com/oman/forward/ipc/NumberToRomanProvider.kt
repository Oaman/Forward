package com.oman.forward.ipc

import android.content.ContentProvider
import android.content.ContentValues
import android.database.Cursor
import android.net.Uri
import android.os.Bundle

/**

 * @author:ZhouJiang
 * @date:2020/3/14 22:18
 * @email:zhoujiang2012@163.com

 */
class NumberToRomanProvider : ContentProvider() {
    companion object {
        const val METHOD_NAME = "numberToRoman"
        const val KEY_NUMBER = "number"
        const val KEY_ROMAN = "roman"
    }

    override fun call(method: String, arg: String?, extras: Bundle?): Bundle? {
        return Bundle().also {
            if (METHOD_NAME == method) {
                val number = extras?.getInt(KEY_NUMBER)
                it.putString(KEY_ROMAN, NumberToRoman.numberToRoman(number!!))
            }
        }
    }

    override fun insert(uri: Uri, values: ContentValues?): Uri? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun query(uri: Uri, projection: Array<out String>?, selection: String?, selectionArgs: Array<out String>?, sortOrder: String?): Cursor? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(): Boolean {
        return true
    }

    override fun update(uri: Uri, values: ContentValues?, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(uri: Uri, selection: String?, selectionArgs: Array<out String>?): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getType(uri: Uri): String? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}