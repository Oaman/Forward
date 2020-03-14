package com.oman.forward.ipc

/**
 * @author:ZhouJiang
 * @date:2020/3/14 14:35
 * @email:zhoujiang2012@163.com
 */
class NumberToRoman {
    companion object {
        //将1-4999数字转换为罗马数字
        fun numberToRoman(num: Int): String {
            var number = num
            val arrInt = intArrayOf(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1)
            val arrStr = arrayOf("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I")
            var roman = ""
            for (i in arrInt.indices) {
                while (number >= arrInt[i]) {
                    roman += arrStr[i]
                    number -= arrInt[i]
                }
            }
            return roman
        }
    }
}