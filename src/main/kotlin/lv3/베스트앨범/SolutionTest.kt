package lv3.베스트앨범

import org.junit.Test
import kotlin.test.assertContentEquals

class SolutionTest {

    @Test
    fun solutionTest() {
        val solution = Solution()

        TestBed.values().forEach {
            assertContentEquals(
                solution.solution(
                    it.input.genres,
                    it.input.plays
                ),
                it.output
            )
        }
    }

    class Input(
        val genres: Array<String>,
        val plays: IntArray
    )

    enum class TestBed(
        val input: Input,
        val output: IntArray
    ){
        Test1(
            Input(
                arrayOf("classic", "pop", "classic", "classic", "pop"),
                intArrayOf(500, 600, 150, 800, 2500)
            ),
            intArrayOf(4, 1, 3, 0)
        )
    }
}