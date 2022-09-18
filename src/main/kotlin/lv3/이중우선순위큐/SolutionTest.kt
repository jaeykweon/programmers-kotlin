package lv3.이중우선순위큐

import org.junit.Test
import kotlin.test.assertContentEquals

class SolutionTest{
    @Test
    fun solutionTest() {
        val solution = Solution()

        TestBed.values().forEach {
            assertContentEquals(solution.solution(it.input),it.output, it.name)
        }

    }

    enum class TestBed(
        val input: Array<String>,
        val output: IntArray
    ){
        Test1(
            arrayOf("I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"),
            intArrayOf(0,0)
        ),
        Test2(
            arrayOf("I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"),
            intArrayOf(333, -45)
        )
    }

}

