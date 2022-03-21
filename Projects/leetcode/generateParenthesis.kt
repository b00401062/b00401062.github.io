package leetcode

import java.util.*

fun generateParenthesis(n: Int): List<String> {
    val stack = Stack<Char>()
    val list = mutableListOf<String>()
    stack.push('(')
    var nl = 1
    var nr = 0
    while (nl != 0) {
        while (nl < n) {
            stack.push('(')
            nl++
        }
        while (nr < n) {
            stack.push(')')
            nr++
        }
        list.add(stack.joinToString(""))
        while (nl == nr) {
            while (stack.pop() == ')')
                nr--
            nl--
            if (nl == 0) break
        }
        stack.push(')')
        nr++
    }
    return list
}