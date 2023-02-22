package lv3.단어변환

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe

internal class SolutionTest: ExpectSpec({

    fun String.canTransform(to: String): Boolean {
        var differ = 0
        this.split("").zip(to.split("")) { _a, _b ->
            if(_a != _b) differ += 1
        }
        return differ == 1
    }

    expect("canTransform") {
        "abc".canTransform("abb") shouldBe true
        "abc".canTransform("acd") shouldBe false
    }

    expect("test") {
        val test = Solution()
        test.solution(
            "hit","cog", arrayOf("hot", "dot", "dog", "lot", "log", "cog")
        ) shouldBe 4

    }
})
