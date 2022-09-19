package lv3.네트워크

import org.junit.Test
import kotlin.test.assertEquals

internal class SolutionTest {
    @Test
    fun solutionTest() {
        val solution = Solution()

        TestBed.values().forEach {
            assertEquals(solution.solution(it.input.n, it.input.computers),it.output, it.name)
        }

    }

    class Input(
        val n: Int,
        val computers: Array<IntArray>
    )

    enum class TestBed(
        val input: Input,
        val output: Int
    ){
        Test1(
            Input(
                3,
                arrayOf(intArrayOf(1, 1, 0),intArrayOf(1, 1, 0),intArrayOf(0, 0, 1))
            ),
            2
        ),
        Test2(
            Input(
                3,
                arrayOf(intArrayOf(1, 1, 0),intArrayOf(1, 1, 1),intArrayOf(0, 1, 1))
            ),
            1
        ),
        CustomTest1(
            Input(
                3,
                arrayOf(intArrayOf(1, 1, 1),intArrayOf(1, 1, 1),intArrayOf(1, 1, 1))
            ),
            1
        ),
        CustomTest2(
            Input(
                4,
                arrayOf(intArrayOf(1, 0, 0, 1),intArrayOf(0, 1, 0, 1),intArrayOf(0, 0, 1, 1),intArrayOf(0, 1, 1, 1))
            ),
            1
        ),
    }
}