import java.util.Arrays // to check array

// 사용자 수 n 만큼 n*n boolean array(신고 테이블), 각 유저별 신고당한 횟수 리스트, 메일 발송 리스트 만들기
// report 돌면서 신고테이블[신고한 사람][신고당한사람] = true로 만들고 원래 false였으면 신고당한 리스트에 += 1
// 신고당한 리스트에서 k개 이상인 사람을 신고한 사람 메일 발송 리스트 +=1

class Solution {
    fun solution(idList: Array<String>, report: Array<String>, k: Int): IntArray {
        val idCount = idList.size
        val idTable = idList.mapIndexed { i, s -> s to i  }.toMap(); // println(idTable)

        val reportCheckArray = Array(idCount) {
            BooleanArray(idCount){false}
        }
        val reportedCountList = IntArray(idCount){0}

        report.forEach {
            val (reportUser, reportedUser) = it.split(" ")
            val reportUserIndex =  idTable.get(reportUser) 
                ?: throw NoSuchElementException("report user not exists")
            val reportedUserIndex = idTable.get(reportedUser) 
                ?: throw NoSuchElementException("reported user not exists")

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

// 결과 //
// 테스트 1 〉	통과 (17.62ms, 64.7MB)
// 테스트 2 〉	통과 (14.39ms, 64.7MB)
// 테스트 3 〉	통과 (128.67ms, 137MB)
// 테스트 4 〉	통과 (29.53ms, 64.4MB)
// 테스트 5 〉	통과 (16.53ms, 65.1MB)
// 테스트 6 〉	통과 (14.02ms, 67.3MB)
// 테스트 7 〉	통과 (16.82ms, 67.1MB)
// 테스트 8 〉	통과 (23.05ms, 81MB)
// 테스트 9 〉	통과 (92.19ms, 109MB)
// 테스트 10 〉	통과 (119.36ms, 111MB)
// 테스트 11 〉	통과 (173.28ms, 139MB)
// 테스트 12 〉	통과 (19.09ms, 62.8MB)
// 테스트 13 〉	통과 (18.76ms, 64.4MB)
// 테스트 14 〉	통과 (175.03ms, 113MB)
// 테스트 15 〉	통과 (162.50ms, 137MB)
// 테스트 16 〉	통과 (15.35ms, 64.8MB)
// 테스트 17 〉	통과 (19.65ms, 64.2MB)
// 테스트 18 〉	통과 (17.74ms, 64.5MB)
// 테스트 19 〉	통과 (15.71ms, 64.6MB)
// 테스트 20 〉	통과 (78.69ms, 110MB)
// 테스트 21 〉	통과 (227.72ms, 139MB)
// 테스트 22 〉	통과 (13.05ms, 63.4MB)
// 테스트 23 〉	통과 (13.16ms, 63.2MB)
// 테스트 24 〉	통과 (9.91ms, 64.9MB)
