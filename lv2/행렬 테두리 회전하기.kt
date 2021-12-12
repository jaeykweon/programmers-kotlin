// import java.util.Arrays // to check array
import java.util.*

class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        
        // 1. rows * columns로 matrix를 만듬
        // 2. matrix[x1][y1]를 큐에 넣음
        // 3. matrix[x1][y1+1]부터 오른쪽으로 가면서 현재 값을 큐에 넣고(queue.offer),
        // 큐 값을 가져와서(queue.poll) 현재 위치에 넣음
        
        val matrix = Array(rows, {
            i -> Array(columns, {
                j -> i*columns + j +1
            })
        })
        // println(Arrays.deepToString(matrix)) // for check
        
        val answer = IntArray(queries.size,{0})
        for((idx,query) in queries.withIndex()){
            val x1 = query[0] - 1
            val y1 = query[1] - 1
            val x2 = query[2] - 1
            val y2 = query[3] - 1
            
            var queue: Queue<Int> = LinkedList<Int>() 
            queue.offer(matrix[x1][y1])
            var min = matrix[x1][y1]
            
            // 위쪽
            for(y in y1+1..y2){
                // min 값 비교
                min = minOf(matrix[x1][y],min)
                // 현재 위치를 큐에 넣음
                queue.offer(matrix[x1][y])
                // 큐 값을 가져와서 현재 위치에 넣음
                matrix[x1][y] = queue.poll()
            }
            
            // 오른쪽
            for(x in x1+1..x2){
                min = minOf(matrix[x][y2],min)
                queue.offer(matrix[x][y2])
                matrix[x][y2] = queue.poll()
            }
            
            // 아래쪽
            for(y in y2-1 downTo y1){
                min = minOf(matrix[x2][y],min)
                queue.offer(matrix[x2][y])
                matrix[x2][y] = queue.poll()
            }
            
            // 왼쪽
            for(x in x2-1 downTo x1){
                min = minOf(matrix[x][y1],min)
                queue.offer(matrix[x][y1])
                matrix[x][y1] = queue.poll()
            }
            
            answer[idx] = min
        }
        
        return answer
    }
}


////
// 테스트 1 〉	통과 (0.21ms, 56.3MB)
// 테스트 2 〉	통과 (0.19ms, 56.6MB)
// 테스트 3 〉	통과 (64.07ms, 88.6MB)
// 테스트 4 〉	통과 (35.59ms, 81.9MB)
// 테스트 5 〉	통과 (53.31ms, 89.6MB)
// 테스트 6 〉	통과 (53.17ms, 90.1MB)
// 테스트 7 〉	통과 (53.14ms, 89.1MB)
// 테스트 8 〉	통과 (36.70ms, 83MB)
// 테스트 9 〉	통과 (42.52ms, 89.1MB)
// 테스트 10 〉	통과 (35.92ms, 88.4MB)
// 테스트 11 〉	통과 (34.24ms, 86MB)
