package lv1.`3진법뒤집기`

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 */
internal class Solution {

    /**
     * input int -> 3진법 -> 10진법
     */
    fun solution(n: Int): Int {
        return Integer.parseInt(n.toString(3).reversed(), 3)
    }
}