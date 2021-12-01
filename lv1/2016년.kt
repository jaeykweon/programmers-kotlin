import java.time.LocalDate;


class Solution {
    fun solution(a: Int, b: Int): String {

        val inputDate = LocalDate.of(2016,a,b)
        return inputDate.getDayOfWeek().toString().substring(0,3)
    }
}

// 참고 : https://hianna.tistory.com/607

////
// 테스트 1 〉	통과 (0.93ms, 56.5MB)
// 테스트 2 〉	통과 (0.84ms, 57.1MB)
// 테스트 3 〉	통과 (0.96ms, 58.3MB)
// 테스트 4 〉	통과 (0.88ms, 56.7MB)
// 테스트 5 〉	통과 (0.97ms, 56.7MB)
// 테스트 6 〉	통과 (0.98ms, 57.9MB)
// 테스트 7 〉	통과 (0.96ms, 56.9MB)
// 테스트 8 〉	통과 (0.98ms, 56.7MB)
// 테스트 9 〉	통과 (1.03ms, 57.2MB)
// 테스트 10 〉	통과 (0.94ms, 57.3MB)
// 테스트 11 〉	통과 (0.97ms, 57MB)
// 테스트 12 〉	통과 (0.99ms, 56.2MB)
// 테스트 13 〉	통과 (0.98ms, 57.3MB)
// 테스트 14 〉	통과 (1.01ms, 56.5MB)
