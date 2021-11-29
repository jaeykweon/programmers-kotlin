class Solution {
    fun solution(n: Int, lostArray: IntArray, reserveArray: IntArray): Int {
        
        // 1. 여분은 더하고, 도난은 뺌
        // 2. 앞뒤로 여분 있는지 알아보되, 맨 앞과 맨 뒤는 따로
        
        // 1
        val wholeList = MutableList<Int>(n,{1})
        for (reserve in reserveArray){
            wholeList[reserve-1] += 1
        }
        for (lost in lostArray){
            wholeList[lost-1] -= 1
        }
        
        // 2
        if (wholeList[0]==0 && wholeList[1]==2){
            wholeList[1] -= 1
            wholeList[0] += 1
        }
        for(i in 1..n-2){
            if (wholeList[i]==0){
                if(wholeList[i-1] == 2){
                    wholeList[i-1] -= 1
                    wholeList[i] +=1
                }else if(wholeList[i+1] == 2){
                    wholeList[i+1] -= 1
                    wholeList[i] +=1
                }
            }
        }
        if (wholeList[n-1]==0 && wholeList[n-2]==2){
            wholeList[n-2] -= 1
            wholeList[n-1] += 1
        }
        
        return wholeList.filter({each -> each>=1}).size
    }
}
