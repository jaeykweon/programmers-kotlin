// 1번 풀이 : 단순 비교
// 2번 풀이 : 비교 후 일치하는 번호 삭제 ( 더 오래 걸림)

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

// 테스트 1 〉	통과 (0.01ms, 58.9MB)
// 테스트 2 〉	통과 (0.01ms, 57MB)
// 테스트 3 〉	통과 (0.01ms, 57.7MB)
// 테스트 4 〉	통과 (0.01ms, 56.3MB)
// 테스트 5 〉	통과 (0.02ms, 58.8MB)
// 테스트 6 〉	통과 (0.02ms, 55.8MB)
// 테스트 7 〉	통과 (0.02ms, 58MB)
// 테스트 8 〉	통과 (0.01ms, 57.3MB)
// 테스트 9 〉	통과 (0.03ms, 57.2MB)
// 테스트 10 〉	통과 (0.03ms, 57.1MB)
// 테스트 11 〉	통과 (0.02ms, 56.4MB)
// 테스트 12 〉	통과 (0.01ms, 56.8MB)
// 테스트 13 〉	통과 (0.01ms, 58.4MB)
// 테스트 14 〉	통과 (0.02ms, 56.9MB)
// 테스트 15 〉	통과 (0.01ms, 57.4MB)





// class Solution {
    
//     // lottos: 구매한 번호 배열
//     // win_nums : 당첨 번호 배열
//     fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        
//         var _win_nums = win_nums.toMutableList()
//         var unknown: Int = 0
//         var matched: Int = 0
        
//         for (lotto in lottos){
//             if(lotto == 0) unknown += 1
//             for(i in 0.._win_nums.size - 1){
//                 if(lotto == _win_nums[i]) {
//                     _win_nums.removeAt(i)
//                     matched += 1
//                     break
//                 }
//             }
//         }
        
//         var answer = intArrayOf(0,0)
//         answer.set(0,7 - matched - unknown)
//         answer.set(1,7 - matched)
        
//         for(i in answer.indices){
//             if(answer[i]==0) answer.set(i,1)
//             else if(answer[i]==7) answer.set(i,6)
//         }
        
//         return answer   // [최고순위, 최저순위]
//     }
// }

// 테스트 1 〉	통과 (10.99ms, 59.1MB)
// 테스트 2 〉	통과 (10.82ms, 58.7MB)
// 테스트 3 〉	통과 (10.59ms, 59.2MB)
// 테스트 4 〉	통과 (11.13ms, 59.5MB)
// 테스트 5 〉	통과 (11.65ms, 59.2MB)
// 테스트 6 〉	통과 (10.60ms, 59.5MB)
// 테스트 7 〉	통과 (11.27ms, 58.5MB)
// 테스트 8 〉	통과 (13.99ms, 58.2MB)
// 테스트 9 〉	통과 (15.59ms, 59MB)
// 테스트 10 〉	통과 (17.47ms, 59.2MB)
// 테스트 11 〉	통과 (10.65ms, 58.8MB)
// 테스트 12 〉	통과 (11.03ms, 58.8MB)
// 테스트 13 〉	통과 (14.16ms, 59.5MB)
// 테스트 14 〉	통과 (10.92ms, 58.9MB)
// 테스트 15 〉	통과 (10.93ms, 59.1MB)
