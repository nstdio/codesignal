package io.github.nstdio.leetcode

fun isBalancedStack(s: String): Boolean {
    if (s.length % 2 != 0)
        return false

    val paren = mapOf('(' to ')', '{' to '}', '[' to ']')
    val deque = ArrayDeque<Char>()

    for (it in s) {
        if (paren.containsKey(it)) {
            deque.add(it)
        } else if (deque.isNotEmpty() && paren[deque.last()] == it) {
            deque.removeLast()
        } else {
            return false
        }
    }

    return deque.isEmpty()
}

fun isBalanced(s: String, withoutStack: Boolean = true): Boolean {
    return if (withoutStack) isBalancedWithoutStack(s) else isBalancedStack(s)
}

fun isBalancedWithoutStack(s: String): Boolean {
    if (s.length % 2 != 0)
        return false

    val sb = StringBuilder(s)
    var i = 0
    while (i < sb.length) {
        val c = sb[i]
        val prev = sb[0.coerceAtLeast(i - 1)]
            
        if ((c == '}' && prev == '{') || (c == ')' && prev == '(') || (c == ']' && prev == '[')) {
            sb.delete(i - 1, i + 1)
            --i
        } else {
            i++
        }
    }

    return sb.isEmpty()
}
