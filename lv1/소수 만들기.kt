import java.util.Arrays

class Solution {
    fun solution(nums: IntArray): Int {
        
        // 1. 3개를 골라 더한 값들의 리스트(combinationList)와 가장 큰 수(mostBigNum)를 만듬
        // 2. 가장 큰 수 크기의 리스트(answerList)를 만들고 에라토스테네스의 체를 구현
        // 3. answerList에서 combinationList 값의 위치를 확인
        
        // 1
        val combinationList = mutableListOf<Int>()
        var mostBigNum :Int = 0
        val size :Int = nums.size
        for(i in 0..size-3){
            for(j in i+1..size-2){
                for(k in j+1..size-1){
                    val combination : Int = nums[i]+nums[j]+nums[k]
                    combinationList.add(combination)
                    if(combination> mostBigNum ) mostBigNum = combination
                }
            }
        }
        
        // 2
        val answerList = Array<Boolean>(mostBigNum,{true})
        for(i in 2..mostBigNum/2){
            for(j in i*2..mostBigNum step i){
                answerList[j-1] = false
            }
        }
        
        // for debug
        // println(combinationList)
        // println(Arrays.toString(answerList))
        
        // 3
        var answer = 0
        for(combinationNum in combinationList){
            if(answerList[combinationNum-1]) answer+=1
        }
 
        return answer
    }
}


////
// 테스트 1 〉	통과 (3.53ms, 58.1MB)
// 테스트 2 〉	통과 (3.75ms, 56.4MB)
// 테스트 3 〉	통과 (3.12ms, 56.8MB)
// 테스트 4 〉	통과 (3.08ms, 56.8MB)
// 테스트 5 〉	통과 (3.83ms, 56.9MB)
// 테스트 6 〉	통과 (6.14ms, 57MB)
// 테스트 7 〉	통과 (3.70ms, 57.5MB)
// 테스트 8 〉	통과 (6.20ms, 57.1MB)
// 테스트 9 〉	통과 (4.74ms, 56.9MB)
// 테스트 10 〉	통과 (6.70ms, 57.1MB)
// 테스트 11 〉	통과 (2.87ms, 56.8MB)
// 테스트 12 〉	통과 (2.96ms, 57.1MB)
// 테스트 13 〉	통과 (2.95ms, 58.6MB)
// 테스트 14 〉	통과 (3.03ms, 57.2MB)
// 테스트 15 〉	통과 (2.94ms, 56.7MB)
// 테스트 16 〉	통과 (7.84ms, 57.3MB)
// 테스트 17 〉	통과 (7.59ms, 57MB)
// 테스트 18 〉	통과 (4.44ms, 59MB)
// 테스트 19 〉	통과 (4.29ms, 57.3MB)
// 테스트 20 〉	통과 (8.43ms, 57.2MB)
// 테스트 21 〉	통과 (7.35ms, 58.1MB)
// 테스트 22 〉	통과 (5.13ms, 57.3MB)
// 테스트 23 〉	통과 (2.67ms, 56.8MB)
// 테스트 24 〉	통과 (7.72ms, 57.2MB)
// 테스트 25 〉	통과 (7.08ms, 57.5MB)
// 테스트 26 〉	통과 (2.55ms, 58.1MB)
