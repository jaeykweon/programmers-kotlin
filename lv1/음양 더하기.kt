class Solution {
    fun solution(a: IntArray, b: IntArray): Int {

        return a.zip(b){_a,_b -> _a * _b }.let{
            it.sum()
        }
    }
}
