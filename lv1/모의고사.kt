import java.util.Arrays // for debug

class Solution {
    fun solution(answers: IntArray): IntArray {
        
        val answerSheetList = listOf(arrayOf(1,0),arrayOf(2,0),arrayOf(3,0))
        val oneAnswer = listOf(1,2,3,4,5)   // 5개씩 반복
        val twoAnswer = listOf(2,1,2,3,2,4,2,5) // 8개씩 반복
        val threeAnswer = listOf(3,3,1,1,2,2,4,4,5,5)   // 10개씩 반복
        for(i in answers.indices){
            if(answers[i] == oneAnswer[i%5]) answerSheetList[0][1] +=1
            if(answers[i] == twoAnswer[i%8]) answerSheetList[1][1] +=1
            if(answers[i] == threeAnswer[i%10]) answerSheetList[2][1] +=1
        }
        answerSheetList.forEach{println(Arrays.toString(it))}   // for debug
        
        var highScore = 0
        val answer = mutableListOf<Int>()
        for(answerSheet in answerSheetList){
            if(answerSheet[1]>highScore){
                highScore = answerSheet[1]
                answer.clear()
                answer.add(answerSheet[0])
            }
            else if(answerSheet[1]==highScore){
                answer.add(answerSheet[0])
            }
        }
        
        return answer.toIntArray()
    }
}


////
// 테스트 1 〉	통과 (12.44ms, 59.8MB)
// 테스트 2 〉	통과 (13.20ms, 59.6MB)
// 테스트 3 〉	통과 (12.88ms, 59.8MB)
// 테스트 4 〉	통과 (12.88ms, 60.3MB)
// 테스트 5 〉	통과 (12.38ms, 59.5MB)
// 테스트 6 〉	통과 (12.76ms, 59.9MB)
// 테스트 7 〉	통과 (13.64ms, 59.9MB)
// 테스트 8 〉	통과 (12.85ms, 59.7MB)
// 테스트 9 〉	통과 (14.45ms, 60.3MB)
// 테스트 10 〉	통과 (13.76ms, 60MB)
// 테스트 11 〉	통과 (15.30ms, 61.2MB)
// 테스트 12 〉	통과 (14.53ms, 60.2MB)
// 테스트 13 〉	통과 (13.11ms, 60MB)
// 테스트 14 〉	통과 (15.26ms, 61.5MB)
