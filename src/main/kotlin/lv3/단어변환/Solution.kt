package lv3.단어변환

import kotlin.math.min

class Solution {

    private var minDepth: Int = Int.MAX_VALUE

    fun solution(begin: String, target: String, words: Array<String>): Int {
        val visited: MutableList<Boolean> = MutableList(words.size) { false }

        backTracking(words, begin, target, visited)

        if(isAvailable().not()) return 0

        return minDepth
    }

    private fun isAvailable(): Boolean {
        if(minDepth == Int.MAX_VALUE) return false
        return true
    }

    private fun backTracking(words: Array<String>, start: String, target: String, visited: MutableList<Boolean>) {

        if(start == target) {
            minDepth = min(minDepth, visited.count { it })
            return
        }

        words.forEachIndexed { idx, word ->
            if(start.canTransform(word) && !visited[idx]) {
                visited[idx] = true
                backTracking(words, word, target, visited)
                visited[idx] = false
            }
        }
    }

    private fun String.canTransform(to: String): Boolean {
        var differ = 0
        this.split("").zip(to.split("")) { _a, _b ->
            if(_a != _b) differ += 1
        }
        return differ == 1
    }
}


