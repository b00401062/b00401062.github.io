package leetcode

import java.util.*

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (c in s) {
        when (c) {
            '(' -> stack.push('(')
            '[' -> stack.push('[')
            '{' -> stack.push('{')
            ')' -> if (stack.isEmpty() || stack.pop() != '(') return false
            ']' -> if (stack.isEmpty() || stack.pop() != '[') return false
            '}' -> if (stack.isEmpty() || stack.pop() != '{') return false
        }
    }
    return stack.isEmpty()
}
