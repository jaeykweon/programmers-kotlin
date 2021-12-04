class Solution {
    fun solution(s: String): Int {
        
        val length = s.length
        if(length <2) return s.length
        
        fun addToList(compressedLengthList:IntArray,i:Int,sameNum:Int,extra:Int = 0){
            // // for debug
            // when(sameNum){
            //     0 -> println(extra)
            //     1 -> println(i + extra)
            //     else -> println(sameNum.toString().length + i + extra)
            // }
            compressedLengthList[i-1] += when(sameNum){
                0 -> extra  // ex) ab bc ca
                1 -> i + extra  // ex) abc ca
                else -> sameNum.toString().length + i + extra // ex) aa aa ba
            }
        }
        
        // println("length: ${length}, length/2: ${length/2}")
        val compressedLengthList = IntArray(length/2,{0})
        for(i in 1..length/2){
            // println("loop : ${i}")
            var j = 1
            var sameNum:Int = 1 // 반복된 횟수
            while(true){
                if(i*(j+1)>length){
                    if(sameNum>=1) addToList(compressedLengthList,i, sameNum, length - i*j)
                    else addToList(compressedLengthList,i, 0, length - i*j)
                    break
                }
                // println("${s.substring(i*(j-1),i*j)} ?= ${s.substring(i*j,i*(j+1))}")
                if(s.substring(i*(j-1),i*j) == s.substring(i*j,i*(j+1))){
                    sameNum += 1
                }else{
                    addToList(compressedLengthList,i,sameNum)
                    sameNum = 1
                }
                j += 1
            }
                    
        }// endfor
        
        // print(compressedLengthList.joinToString())
        return compressedLengthList.min()!!
    }
}


////
// 테스트 1 〉	통과 (11.22ms, 59MB)
// 테스트 2 〉	통과 (11.64ms, 59.3MB)
// 테스트 3 〉	통과 (11.58ms, 58.8MB)
// 테스트 4 〉	통과 (11.22ms, 59.1MB)
// 테스트 5 〉	통과 (0.02ms, 56.3MB)
// 테스트 6 〉	통과 (11.10ms, 59MB)
// 테스트 7 〉	통과 (11.70ms, 58.6MB)
// 테스트 8 〉	통과 (11.71ms, 59.3MB)
// 테스트 9 〉	통과 (12.93ms, 59.1MB)
// 테스트 10 〉	통과 (14.36ms, 59.5MB)
// 테스트 11 〉	통과 (12.89ms, 60MB)
// 테스트 12 〉	통과 (11.28ms, 58.4MB)
// 테스트 13 〉	통과 (11.28ms, 59.3MB)
// 테스트 14 〉	통과 (12.06ms, 59.1MB)
// 테스트 15 〉	통과 (11.32ms, 59.7MB)
// 테스트 16 〉	통과 (11.19ms, 59.4MB)
// 테스트 17 〉	통과 (12.53ms, 59.1MB)
// 테스트 18 〉	통과 (12.54ms, 59MB)
// 테스트 19 〉	통과 (12.61ms, 59.1MB)
// 테스트 20 〉	통과 (14.04ms, 59.9MB)
// 테스트 21 〉	통과 (19.52ms, 60.4MB)
// 테스트 22 〉	통과 (15.73ms, 59.3MB)
// 테스트 23 〉	통과 (15.01ms, 60.1MB)
// 테스트 24 〉	통과 (15.62ms, 60.2MB)
// 테스트 25 〉	통과 (16.90ms, 59.9MB)
// 테스트 26 〉	통과 (17.45ms, 60.3MB)
// 테스트 27 〉	통과 (14.92ms, 60.7MB)
// 테스트 28 〉	통과 (17.22ms, 59.4MB)
