package lv3.네트워크

internal class Solution {
    // 0. 방문 리스트 생성 (n개 짜리)
    // 1. 일단 A부터 시작해서 dfs로 찾는다
    // 2. A에 연결된 노드를 순차 방문
    // 3. 해당 노드에 연결된 노드가 있다면 또 방문
    // 4. 없다면 해당 노드는 끝
    // 5. 이미 방문한 노드는 제외하고 순차 방문
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val visitedList = BooleanArray(n) { false }

        computers.forEachIndexed Continue@{ y, _ ->
            if(visitedList[y]) return@Continue
            recurse(visitedList, computers, y)
            answer += 1
        }

        return answer
    }

    private fun recurse(visitedList: BooleanArray, computers: Array<IntArray>, current: Int) {
        visitedList[current] = true
        computers[current]
            .mapIndexed{ idx, value -> Pair(idx, value) }
            .filter { visitedList[it.first] == false && it.second == 1 }
            .forEach {
                recurse(visitedList, computers, it.first)
            }
    }
}
