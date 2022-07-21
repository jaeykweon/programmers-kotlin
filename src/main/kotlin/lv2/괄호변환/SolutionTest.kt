package lv2.괄호변환

import org.junit.Test
import kotlin.test.assertEquals

internal class SolutionTest{

    @Test
    fun solutionTest(){

        val testBed = listOf(
            "(()())()",
            ")(",
            "()))((()"
        )
        val answerList = listOf(
            "(()())()",
            "()",
            "()(())()"
        )

        val myLogic = Solution()
        val myAnswerList = testBed.map {
            myLogic.solution(it)
        }

        val answerPair = answerList.zip(myAnswerList)

        answerPair.forEach {
            println(it.first + ":" + it.second)
            assertEquals(it.first, it.second)
        }

    }

}