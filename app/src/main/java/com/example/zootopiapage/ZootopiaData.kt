package com.example.zootopiapage

object ZootopiaData {
    fun get(): MutableList<ZootopiaInfo> {

        val zootopiaList = mutableListOf<ZootopiaInfo>()
        val data1 = ZootopiaInfo(
            R.drawable.apple,
            "애플",
            "010-0000-0924",
            "apple@zootopia.com"
        )
        zootopiaList.add(data1)
        val data2 = ZootopiaInfo(
            R.drawable.nook,
            "너굴",
            "010-0000-0530",
            "nook@zootopia.com"
        )
        zootopiaList.add(data2)
        val data3 = ZootopiaInfo(
            R.drawable.flurry,
            "뽀야미",
            "010-0000-0130",
            "flurry@zootopia.com"
        )
        zootopiaList.add(data3)
        val data4 = ZootopiaInfo(
            R.drawable.cider,
            "사이다",
            "010-0000-0327",
            "cider@zootopia.com"
        )
        zootopiaList.add(data4)
        val data5 = ZootopiaInfo(
            R.drawable.jjuni,
            "쭈니",
            "010-0000-0929",
            "jjuni@zootopia.com"
        )
        zootopiaList.add(data5)
        val data6 = ZootopiaInfo(
            R.drawable.jackson,
            "잭슨",
            "010-0000-1001",
            "jackson@zootopia.com"
        )
        zootopiaList.add(data6)
        val data7 = ZootopiaInfo(
            R.drawable.judy,
            "미애",
            "010-0000-0310",
            "judy@zootopia.com"
        )
        zootopiaList.add(data7)
        val data8 = ZootopiaInfo(
            R.drawable.michel,
            "미첼",
            "010-0000-0519",
            "michel@zootopia.com"
        )
        zootopiaList.add(data8)
        val data9 = ZootopiaInfo(
            R.drawable.yobi,
            "요비",
            "010-0000-1031",
            "yobi@zootopia.com"
        )
        zootopiaList.add(data9)
        val data10 = ZootopiaInfo(
            R.drawable.pach,
            "패치",
            "010-0000-0210",
            "pach@zootopia.com"
        )
        zootopiaList.add(data10)

        return zootopiaList
    }
}