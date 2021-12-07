class Solution {
    fun solution(w: Int, h: Int): Long {
        
        // https://notepad96.tistory.com/entry/Android-1
        fun gcd(a: Int, b:Int): Long = if(b != 0) gcd(b, a % b) else a.toLong()
        
        return (w.toLong() * h.toLong()) - (w + h - gcd(w,h))
    }
}

////
// 테스트 1 〉	통과 (0.42ms, 56.9MB)
// 테스트 2 〉	통과 (1.83ms, 56.9MB)
// 테스트 3 〉	통과 (0.39ms, 56.9MB)
// 테스트 4 〉	통과 (0.38ms, 57MB)
// 테스트 5 〉	통과 (0.39ms, 56.7MB)
// 테스트 6 〉	통과 (0.40ms, 56.6MB)
// 테스트 7 〉	통과 (0.45ms, 55.7MB)
// 테스트 8 〉	통과 (0.48ms, 56.6MB)
// 테스트 9 〉	통과 (0.37ms, 57.3MB)
// 테스트 10 〉	통과 (0.39ms, 56.6MB)
// 테스트 11 〉	통과 (0.42ms, 57.8MB)
// 테스트 12 〉	통과 (0.42ms, 56.4MB)
// 테스트 13 〉	통과 (0.41ms, 56.2MB)
// 테스트 14 〉	통과 (0.40ms, 57.3MB)
// 테스트 15 〉	통과 (0.41ms, 56.6MB)
// 테스트 16 〉	통과 (0.39ms, 58MB)
// 테스트 17 〉	통과 (0.38ms, 56.9MB)
// 테스트 18 〉	통과 (0.39ms, 56.5MB)
