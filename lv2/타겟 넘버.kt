class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        
        var treeList = mutableListOf<Int>(0)
        
        for (number in numbers){
            val subTree = mutableListOf<Int>()
            for(tree in treeList){
                subTree.add(tree+number)
                subTree.add(tree-number)
            }
            treeList = subTree
        }

        return treeList.count{it == target}
    }
}

////
// 테스트 1 〉	통과 (82.99ms, 109MB)
// 테스트 2 〉	통과 (72.30ms, 93MB)
// 테스트 3 〉	통과 (5.02ms, 57.1MB)
// 테스트 4 〉	통과 (5.92ms, 57.2MB)
// 테스트 5 〉	통과 (14.34ms, 59.1MB)
// 테스트 6 〉	통과 (5.02ms, 57.8MB)
// 테스트 7 〉	통과 (5.02ms, 57.1MB)
// 테스트 8 〉	통과 (6.55ms, 57.2MB)
