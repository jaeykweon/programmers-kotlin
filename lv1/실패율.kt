import java.util.Arrays

class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        
        // 테스트 하기위해 일부러 2d array로 만듬
        val stageState = Array<Array<Int>>(N,{i -> arrayOf(i+1,0)})
        // println(Arrays.deepToString(stageState)) // [[1, 0], [2, 0], [3, 0], [4, 0], [5, 0]]
        for(stage in stages){
            if(stage == N+1 ) continue
            stageState[stage-1][1] += 1
        } 
        // println(Arrays.deepToString(stageState)) // [[1, 1], [2, 3], [3, 2], [4, 1], [5, 0]]
        
        var stageChallengedNum = stages.size
        val failureRateArray = mutableListOf<Pair<Int,Double>>()
        for(i in stageState.indices){
            if(stageChallengedNum == 0){
                failureRateArray.add(Pair(i+1,0.0))
                continue
            } 
            failureRateArray.add(Pair(i+1,stageState[i][1].toDouble() / stageChallengedNum))
            stageChallengedNum -= stageState[i][1]
        }
        // println(failureRateArray.toString())
        // [(1, 0.125), (2, 0.42857142857142855), (3, 0.5), (4, 0.5), (5, 0.0)]

        // // val test = arrayTest.sortedWith(compareBy({it[1]})).toTypedArray()
        val sortedFailureRateArray = failureRateArray.sortedWith(compareByDescending({it.second})) 
        // type : List<Pair<Int, Double>>
        // array로 바꾸려면 .toTypedArray()?
        
        val answer = mutableListOf<Int>()
        for(each in sortedFailureRateArray){
            answer.add(each.component1())
        }
        return answer.toIntArray()
    }
}
