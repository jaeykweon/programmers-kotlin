package lv1.신고결과받기

internal class Solution {

    // 사용자 수 n 만큼 n*n boolean array(신고 테이블), 각 유저별 신고당한 횟수 리스트, 메일 발송 리스트 만들기
    // report 돌면서 신고테이블[신고한 사람][신고당한사람] = true
    // 신고테이블 돌면서 신고당한 리스트에 += 1
    // 신고당한 리스트에서 k개 이상인 사람을 신고한 사람 메일 발송 리스트 +=1

    fun solution(idList: Array<String>, report: Array<String>, k: Int): IntArray {
        val idCount = idList.size
        val idTable = idList.mapIndexed { i, s -> s to i  }.toMap(); // println(idTable)

        val reportCheckArray = Array(idCount) {
            BooleanArray(idCount){false}
        }
        val reportedCountList = IntArray(idCount){0}

        report.forEach {
            val (reportUser, reportedUser) = it.split(" ")
            val reportUserIndex =  idTable.get(reportUser) ?: throw NoSuchElementException("report user not exists")
            val reportedUserIndex = idTable.get(reportedUser) ?: throw NoSuchElementException("reported user not exists")

            if(!reportCheckArray[reportUserIndex][reportedUserIndex]) { // 신규 신고
                reportedCountList[reportedUserIndex] += 1
                reportCheckArray[reportUserIndex][reportedUserIndex] = true
            }
        }; // println(Arrays.deepToString(reportCheckArray)) // for check

        val answer = IntArray(idCount){0}
        for ((i, v) in reportedCountList.withIndex()) {
            if(v < k) continue
            for(l in 0 until idCount){
                if(reportCheckArray[l][i]) answer[l] +=1
            }
        }
        return answer
    }

}