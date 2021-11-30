class Solution {
    fun solution(n: Int): Int {
        // n -> 3진법 -> 10진법
        return Integer.parseInt(n.toString(3).reversed(), 3)
    }
}
