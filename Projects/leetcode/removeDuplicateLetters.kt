package leetcode

import java.util.Stack
import java.lang.StringBuilder

internal object RemoveDuplicateLetters {
    fun removeDuplicateLetters(s: String): String {
        val seen = BooleanArray(26)
        val count = IntArray(26)
        for (c in s.toCharArray()) {
            count[c - 'a']++
        }
        val stack = Stack<Char>()
        for (c in s.toCharArray()) {
            count[c - 'a']--
            if (seen[c - 'a']) {
                continue
            }
            while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
                seen[stack.pop() - 'a'] = false
            }
            stack.push(c)
            seen[c - 'a'] = true
        }
        val subsequence = StringBuilder()
        while (!stack.isEmpty()) {
            subsequence.append(stack.pop())
        }
        return subsequence.reverse().toString()
    }
}