package leetcode

import java.util.stream.StreamSupport

fun climbStairs(n: Int): Int {
    return StreamSupport.stream(Fibonacci().spliterator(), false).skip(n.toLong()).findFirst().get()
}

private class Fibonacci : Iterable<Int?> {
    override fun iterator(): Iterator<Int?> {
        return object : Iterator<Int?> {
            var cache = intArrayOf(1, 1)
            override fun hasNext(): Boolean {
                return true
            }

            override fun next(): Int {
                val value = cache[0]
                cache[0] = cache[1]
                cache[1] = value + cache[0]
                return value
            }
        }
    }
}
