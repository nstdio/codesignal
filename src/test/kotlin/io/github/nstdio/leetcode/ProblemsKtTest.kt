package io.github.nstdio.leetcode

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class ProblemsKtTest {

    @Test
    fun isValid() {
        isBalanced("{{}[][[[]]]}") shouldBe true
        isBalanced("([)]") shouldBe false

        isBalanced("{{{}}") shouldBe false
        isBalanced("{}[]{{}}") shouldBe true
        isBalanced("{}}") shouldBe false
    }
}