package lv1.신고결과받기

import org.junit.Test


class SolutionTest{

    @Test
    fun solution() {
        val testClass = Solution()
        testCaseList.forEach{
            testClass.solution(
                idList = it.key.idList,
                report = it.key.report,
                k = it.key.k
            ) contentEquals it.value
        }
    }

    companion object {
        class TestCase(
            val idList: Array<String>,
            val report: Array<String>,
            val k: Int
        )

        val testCaseList = mapOf(
            TestCase(
                idList = arrayOf("muzi", "frodo", "apeach", "neo"),
                report = arrayOf("muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"),
                k = 2
            ) to IntArray(4,{2;1;1;0}),
            TestCase(
                idList = arrayOf("con", "ryan"),
                report = arrayOf("ryan con", "ryan con", "ryan con", "ryan con"),
                k = 3
            ) to IntArray(2,{0;0})
        )

    }

}