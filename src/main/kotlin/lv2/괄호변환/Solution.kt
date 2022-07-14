package lv2.괄호변환

internal class Solution {

    fun execute(inputString: String): String {
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
            stringBuilder.append(execute(v))
        }
        else{ // 올바른 괄호 문자열이 아닐 때
            stringBuilder.append('(')
            stringBuilder.append(execute(v))
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