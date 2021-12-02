class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        
        // doesn't need it
        // fun bigNumOf(oldNum:Int,newNum:Int):Int {
        //     return if(oldNum>newNum) oldNum else newNum
        // }
        
        var maxWidth = 0
        var maxHeight = 0
        
        for(size in sizes){
            if(size[0]>size[1]){
                maxWidth = if(maxWidth>size[0]) maxWidth else size[0]
                maxHeight = if(maxHeight>size[1]) maxHeight else size[1]
            }else{
                maxWidth = if(maxWidth>size[1]) maxWidth else size[1]
                maxHeight = if(maxHeight>size[0]) maxHeight else size[0]
            }
        }
        
        return maxWidth * maxHeight
    }
}
