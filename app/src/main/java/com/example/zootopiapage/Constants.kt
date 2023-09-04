package com.example.zootopiapage

object Constants {
    fun getZootopiaData(): MutableList<ZootopiaInfo> {

        val zootopiaList = mutableListOf<ZootopiaInfo>()
        val data1 = ZootopiaInfo(
            R.drawable.apple,
            "애플",
            "9월 24일",
            "010-0000-0924",
            "사람들은 닮기 마련",
            "놀이"
        )
        zootopiaList.add(data1)
        val data2 = ZootopiaInfo(
            R.drawable.nook,
            "너굴",
            "5월 30일",
            "010-0000-0530",
            "밑지는 장사 없다",
            "은행"
        )
        zootopiaList.add(data2)
        val data3 = ZootopiaInfo(
            R.drawable.flurry,
            "뽀야미",
            "1월 30일",
            "010-0000-0130",
            "눈에 넣어도 안 아프다",
            "자연"
        )
        zootopiaList.add(data3)
        val data4 = ZootopiaInfo(
            R.drawable.cider,
            "사이다",
            "3월 27일",
            "010-0000-0327",
            "고양이도 밟으면 꿈틀한다",
            "음악"
        )
        zootopiaList.add(data4)
        val data5 = ZootopiaInfo(
            R.drawable.jjuni,
            "쭈니",
            "9월 29일",
            "010-0000-0929",
            "천재일우",
            "음악"
        )
        zootopiaList.add(data5)
        val data6 = ZootopiaInfo(
            R.drawable.jackson,
            "잭슨",
            "10월 1일",
            "010-0000-1001",
            "셀프 브랜딩",
            "자연 연구"
        )
        zootopiaList.add(data6)
        val data7 = ZootopiaInfo(
            R.drawable.judy,
            "미애",
            "3월 10일",
            "010-0000-0310",
            "꿈 속에서는 영원히 춤 출 수 있다",
            "음악"
        )
        zootopiaList.add(data7)
        val data8 = ZootopiaInfo(
            R.drawable.michel,
            "미첼",
            "5월 19일",
            "010-0000-0519",
            "중요한 건 타이밍",
            "패션"
        )
        zootopiaList.add(data8)
        val data9 = ZootopiaInfo(
            R.drawable.yobi,
            "요비",
            "10월 31일",
            "010-0000-1031",
            "먼 친척보다 가까운 도깨비",
            "교육"
        )
        zootopiaList.add(data9)
        val data10 = ZootopiaInfo(
            R.drawable.pach,
            "패치",
            "2월 10일",
            "010-0000-0210",
            "누더기 인생",
            "놀이"
        )
        zootopiaList.add(data10)

        return zootopiaList
    }
}