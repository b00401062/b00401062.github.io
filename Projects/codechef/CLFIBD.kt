package codechef

import java.io.IOException
import java.util.*

internal object CLFIBD {
    private fun check(c: IntArray): Boolean {
        var c = c
        c = Arrays.stream(c).filter { i: Int -> i != 0 }.toArray()
        Arrays.sort(c)
        var flag = true
        for (i in 0 until c.size - 2) {
            if (c[i] + c[i + 1] != c[i + 2]) {
                flag = false
            }
        }
        if (flag) return true
        c[0] = c[0] xor c[1] xor c[0].also { c[1] = it }
        for (i in 0 until c.size - 2) {
            if (c[i] + c[i + 1] != c[i + 2]) {
                return false
            }
        }
        return true
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var t = stdin.nextInt()
        while (t-- > 0) {
            val c = IntArray(26)
            stdin.next().chars().forEach { i: Int -> c[i - 'a'.toInt()]++ }
            println(if (check(c)) "Dynamic" else "Not")
        }
        stdin.close()
    }
}