class Solution {
    
    // lottos: 구매한 번호 배열
    // win_nums : 당첨 번호 배열
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        
        var unknown: Int = 0
        var matched: Int = 0
        
        for (lotto in lottos){
            if(lotto == 0) unknown += 1
            for(win_num in win_nums){
                if(lotto == win_num) {
                    matched += 1
                    break
                }
            }
        } //endfor
        
        var answer = intArrayOf(0,0)
        answer.set(0,7 - matched - unknown)
        answer.set(1,7 - matched)
        
        for(i in answer.indices){
            if(answer[i]==0) answer.set(i,1)
            else if(answer[i]==7) answer.set(i,6)
        }
        
        return answer   // [최고순위, 최저순위]
    }
}
