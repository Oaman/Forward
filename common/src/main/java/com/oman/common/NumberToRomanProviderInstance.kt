package com.oman.common

import android.content.Context
import android.net.Uri
import androidx.core.os.bundleOf

/**

 * @author:ZhouJiang
 * @date:2020/3/14 22:24
 * @email:zhoujiang2012@163.com

 */
class NumberToRomanProviderInstance {

    companion object {
        const val AUTHORITY = "content://com.oman.forward.provider.numbertoromanprovider"
        const val METHOD_NAME = "numberToRoman"
        const val KEY_NUMBER = "number"
        const val KEY_ROMAN = "roman"

        @Volatile
        private var instance: NumberToRomanProviderInstance? = null

        fun getInstance(context: Context): NumberToRomanProviderInstance {
            return instance ?: synchronized(this) {
                instance ?: NumberToRomanProviderInstance().also {
                    instance = it
                }
            }
        }
    }

    fun getRoman(context: Context, number: Int): String? {
        val bundle = bundleOf(KEY_NUMBER to number)
        context.contentResolver.call(Uri.parse(AUTHORITY), METHOD_NAME, null, bundle)?.let {
            return it.getString(KEY_ROMAN, "")
        }
        return null
    }
}