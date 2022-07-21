package lv1.`3진법뒤집기`

import org.junit.Test
import kotlin.test.assertEquals

class SolutionTest {

    @Test
    fun solution() {
        val testClass = Solution()
        testCaseList.forEach{
            assertEquals(testClass.solution(it.input), it.output)
        }
    }

    companion object {
        class TestCase(
            val input: Int,
            val output: Int
        )

        val testCaseList = arrayOf(
            TestCase(45,7),
            TestCase(125,229)
        )
    }
}