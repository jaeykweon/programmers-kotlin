import kotlin.math.*

class Solution {
    fun solution(left: Int, right: Int): Int {
        
        var answer: Int = 0
        for(num in left..right){    // 제곱근과 제곱근의 내림이 같으면 제곱수이고, 제곱수는 약수가 홀수
            answer += if(sqrt(num.toDouble()) - floor(sqrt(num.toDouble())) == 0.0) -num else num
        }
        
        return answer
    }
}


////
// 테스트 1 〉	통과 (0.58ms, 56.9MB)
// 테스트 2 〉	통과 (0.38ms, 56.4MB)
// 테스트 3 〉	통과 (0.44ms, 56.6MB)
// 테스트 4 〉	통과 (0.25ms, 56MB)
// 테스트 5 〉	통과 (0.57ms, 56.3MB)
// 테스트 6 〉	통과 (0.24ms, 56.4MB)
// 테스트 7 〉	통과 (0.25ms, 56.1MB)
