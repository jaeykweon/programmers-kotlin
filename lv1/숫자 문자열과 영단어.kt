class Solution {
    fun solution(string: String): Int {

        var answer = StringBuilder()
        var _answer = StringBuilder()

        for (s in string){
            _answer.append(s)
            val __answer:String = when(_answer.toString()){
                in "0".."9" -> _answer.toString()
                "zero" -> "0"
                "one" -> "1"
                "two" -> "2"
                "three" -> "3"
                "four" -> "4"
                "five" -> "5"
                "six" -> "6"
                "seven" -> "7"
                "eight" -> "8"
                "nine" -> "9"
                else -> "."
            }
            if (__answer == ".") continue
            answer.append(__answer)
            _answer.clear()
        }
        return answer.toString().toInt()
    }
}
