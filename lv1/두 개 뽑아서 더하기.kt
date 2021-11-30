class Solution {
    fun solution(numbers: IntArray): IntArray {
        
        if(numbers.size==2) return intArrayOf(numbers[0]+numbers[1])
        
        val numArray = BooleanArray(201,{false})    // 0부터 200까지 총 201개 가능
        for(i in 0..numbers.size-2){
            for(j in i+1..numbers.size-1){
                numArray[numbers[i] + numbers[j]] = true
            }
        } // endfor
        
        return numArray.withIndex().filter{ it.value == true }.map{ it.index }.toIntArray()
    }
}
