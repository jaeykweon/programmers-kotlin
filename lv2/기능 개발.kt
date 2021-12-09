import kotlin.math.ceil

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {

        // 순차적으로 progresses의 각 항목을 speeds의 항목으로 나누어 나감(각 기능별 소요시간)
        // 이전 소요시간보다 현재 소요시간이 더 길면 doneSameTime 커밋
        // 이전 소요시간이 더 길면 doneSameTime +=1
        // 마지막꺼는 다음꺼가 없으므로 따로 더해줌

        var answer = mutableListOf<Int>()
        var doneSameTime = 1
        var before = ceil((100 - progresses[0].toDouble()) / speeds[0]).toInt()

        for(idx in 1..progresses.size-1){
            var now = ceil((100 - progresses[idx].toDouble()) / speeds[idx]).toInt()
            // println("before: ${before}")
            // println("now: ${now}")          
            if(before>=now) doneSameTime +=1
            else{
                answer.add(doneSameTime)
                doneSameTime = 1
                before = now
            }

            if(idx == progresses.size-1) {
                answer.add(doneSameTime)
            }
        }

        return answer.toIntArray()
    }
}


////
// 테스트 1 〉	통과 (5.38ms, 57.1MB)
// 테스트 2 〉	통과 (6.91ms, 57.2MB)
// 테스트 3 〉	통과 (6.69ms, 57.7MB)
// 테스트 4 〉	통과 (5.93ms, 57.8MB)
// 테스트 5 〉	통과 (5.19ms, 57.3MB)
// 테스트 6 〉	통과 (5.12ms, 57.1MB)
// 테스트 7 〉	통과 (5.77ms, 57.1MB)
// 테스트 8 〉	통과 (5.17ms, 57.2MB)
// 테스트 9 〉	통과 (5.28ms, 57.1MB)
// 테스트 10 〉	통과 (5.17ms, 57.6MB)
// 테스트 11 〉	통과 (5.15ms, 58MB)
