class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {

        val size = commands.size
        val answer = IntArray(size,{0})
        for (i in 0..size-1){
            answer[i] = array.slice(commands[i][0]-1..commands[i][1]-1)
                                    .let{
                                        it.sorted()
                                    }.let{
                                        it[commands[i][2]-1]
                                    }
        } //endfor

        return answer
    }
}
