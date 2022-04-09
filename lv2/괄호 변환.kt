class Solution {
    fun solution(inputString: String): String {
        if(inputString.length == 0) return ""

        val stringBuilder = StringBuilder()

        var balanceNum = 0
        var divideIndex = 0
        for(currentIndex in 0..inputString.length-1) {
            if(inputString[currentIndex] == '(') balanceNum+=1
            else balanceNum -= 1
            if(balanceNum == 0) {
                divideIndex = currentIndex
                break
            }
        }

        val u = inputString.substring(0,divideIndex+1)
        val v = inputString.substring(divideIndex+1)

        if(u[0] == '('){ // 올바른 괄호 문자열일 때
            stringBuilder.append(u)
            stringBuilder.append(solution(v))
        }
        else{ // 올바른 괄호 문자열이 아닐 때
            stringBuilder.append('(')
            stringBuilder.append(solution(v))
            stringBuilder.append(')')
            u.substring(1, u.length-1).forEach {
                stringBuilder.append(
                    if (it == '(') ")" else "("
                )
            }
        }

        return stringBuilder.toString()
    }
}


// 테스트 1 〉	통과 (0.04ms, 63.6MB)
// 테스트 2 〉	통과 (0.05ms, 62MB)
// 테스트 3 〉	통과 (0.04ms, 64.8MB)
// 테스트 4 〉	통과 (0.07ms, 63.3MB)
// 테스트 5 〉	통과 (0.04ms, 63MB)
// 테스트 6 〉	통과 (0.05ms, 63.6MB)
// 테스트 7 〉	통과 (0.05ms, 63.6MB)
// 테스트 8 〉	통과 (0.04ms, 63.3MB)
// 테스트 9 〉	통과 (0.05ms, 63.2MB)
// 테스트 10 〉	통과 (0.08ms, 62.1MB)
// 테스트 11 〉	통과 (0.11ms, 61.9MB)
// 테스트 12 〉	통과 (0.07ms, 63MB)
// 테스트 13 〉	통과 (0.10ms, 61.8MB)
// 테스트 14 〉	통과 (0.12ms, 63.3MB)
// 테스트 15 〉	통과 (0.12ms, 61MB)
// 테스트 16 〉	통과 (0.32ms, 63.2MB)
// 테스트 17 〉	통과 (0.12ms, 64.3MB)
// 테스트 18 〉	통과 (0.21ms, 65.2MB)
// 테스트 19 〉	통과 (0.36ms, 64.4MB)
// 테스트 20 〉	통과 (0.26ms, 63.6MB)
// 테스트 21 〉	통과 (0.27ms, 62.9MB)
// 테스트 22 〉	통과 (0.15ms, 64.5MB)
// 테스트 23 〉	통과 (0.27ms, 63.6MB)
// 테스트 24 〉	통과 (0.08ms, 64.5MB)
// 테스트 25 〉	통과 (0.15ms, 63.1MB)
