package org.example

import java.util.*


class SpringArray {
    // ASSUMING GIVEN EXPRESSIONS ARE BALANCED
    companion object {

        private fun String.isParallel() = first() == '[' && last() == ']'
        fun equivalentSpring(springExpr: String): Spring {
            val body = springExpr.substring(1, springExpr.lastIndex)
            if (body.isEmpty()) {
                return Spring(0.0)
            }
            val stack = Stack<Spring>()
            for (element in body) {
                when (element) {
                    '{', '[' -> stack.push(Spring())
                    '}', ']' -> combine(stack, springExpr.isParallel())
                }
            }
            return stack.pop()
        }

        fun equivalentSpring(exp: String, springs: Array<Spring>): Spring {
            val body = exp.substring(1, exp.lastIndex)
            if (body.isEmpty()) {
                return Spring(0.0)
            }
            val stack = Stack<Spring>()
            for (element in exp) {
                when (element) {
                    '{', '[' -> stack.push(springs[0])
                    '}', ']' -> combine(stack, exp.isParallel())
                }
            }
            return stack.pop()
        }

        private fun combine(stack: Stack<Spring>, isInParallel: Boolean) {
            val s1 = stack.pop()
            if (!stack.isEmpty()) {
                val s2 = stack.peek()
                stack.pop()
                stack.push(if (isInParallel) s2.inParallel(s1) else s2.inSeries(s1))
            } else {
                stack.push(s1)
            }
        }
    }
}