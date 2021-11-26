class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {

        val size = board[0].size
        var logging = MutableList<Int>(size,{i->0})
        var baguni = mutableListOf<Int>()
        var answer = 0

        fun checkTwice(baguni:MutableList<Int>,answer:Int):Pair<MutableList<Int>,Int>{
            var _answer:Int = answer
            if(baguni.size>1){
                if(baguni[baguni.size-1] == baguni[baguni.size-2]){
                    baguni.removeAt(baguni.size-1)
                    baguni.removeAt(baguni.size-1)
                    _answer += 2
                }
            }//endwhile
            return Pair(baguni, _answer)
        }

        for (move in moves){
            if(logging[move-1]==size) continue  //비워져 있다면 다음꺼
            for(i in logging[move-1]..size-1){
                if (board[i][move-1] == 0) continue // 빈칸이면 다음꺼
                baguni.add(board[i][move-1])
                logging[move-1] = i+1
                val _checkTwice = checkTwice(baguni,answer)
                baguni = _checkTwice.first
                answer = _checkTwice.second
                break
            }//endfor
        }//endfor

        return answer
    }
}
