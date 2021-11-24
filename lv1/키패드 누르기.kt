import kotlin.math.*

class Solution {
    
    fun solution(numbers: IntArray, hand: String): String {
        
        val defaultHand:Char = when(hand){
            "left" -> 'L'
            "right" -> 'R'
            else -> 'R' // 의미없음
        }
        var leftHand = intArrayOf(0,3)
        var rightHand = intArrayOf(2,3)
        var answer = StringBuilder()
        
        fun checkDistance(
                nextNumberMatix:IntArray,
                leftHand:IntArray,
                rightHand:IntArray,
                defaulHand:Char
                ):Triple<IntArray,IntArray,Char> {
            val toLeftDistance = (nextNumberMatix[0] - leftHand[0]).absoluteValue +
                                    (nextNumberMatix[1] - leftHand[1]).absoluteValue
            val toRightDistance = (nextNumberMatix[0] - rightHand[0]).absoluteValue +
                                    (nextNumberMatix[1] - rightHand[1]).absoluteValue
            if(toLeftDistance>toRightDistance) return Triple(leftHand,nextNumberMatix,'R')
            else if (toLeftDistance<toRightDistance) return Triple(nextNumberMatix,rightHand,'L')
            
            // 거리가 같은 경우
            if (defaulHand == 'L') return Triple(nextNumberMatix,rightHand,'L')
            return Triple(leftHand,nextNumberMatix,'R')
        }
        
        for(number in numbers){
            var nextNumberMatrix:IntArray = if (number == 0) intArrayOf(1,3)
                                    else intArrayOf((number-1)%3,(number-1)/3)
            if(listOf(1,4,7).contains(number)){
                answer.append('L')
                leftHand = nextNumberMatrix
            }else if(listOf(3,6,9).contains(number)){
                answer.append('R')
                rightHand = nextNumberMatrix
            }
            else{
                val _checkDistance = checkDistance(nextNumberMatrix,leftHand,rightHand,defaultHand)
                leftHand = _checkDistance.first
                rightHand = _checkDistance.second
                answer.append(_checkDistance.third)
            }
        }
        
        return answer.toString()
    }
}

// 테스트 1 〉	통과 (11.54ms, 60.3MB)
// 테스트 2 〉	통과 (12.56ms, 59.3MB)
// 테스트 3 〉	통과 (12.30ms, 59.9MB)
// 테스트 4 〉	통과 (12.30ms, 60.3MB)
// 테스트 5 〉	통과 (11.90ms, 59.9MB)
// 테스트 6 〉	통과 (12.06ms, 59.8MB)
// 테스트 7 〉	통과 (12.68ms, 60.1MB)
// 테스트 8 〉	통과 (12.24ms, 59.8MB)
// 테스트 9 〉	통과 (17.16ms, 59.8MB)
// 테스트 10 〉	통과 (12.65ms, 61.8MB)
// 테스트 11 〉	통과 (12.17ms, 60.3MB)
// 테스트 12 〉	통과 (12.80ms, 60.5MB)
// 테스트 13 〉	통과 (12.14ms, 59.8MB)
// 테스트 14 〉	통과 (13.12ms, 60.1MB)
// 테스트 15 〉	통과 (13.70ms, 60.4MB)
// 테스트 16 〉	통과 (14.03ms, 59.9MB)
// 테스트 17 〉	통과 (13.54ms, 60.1MB)
// 테스트 18 〉	통과 (18.56ms, 59.9MB)
// 테스트 19 〉	통과 (15.81ms, 60.8MB)
// 테스트 20 〉	통과 (16.00ms, 60.5MB)
