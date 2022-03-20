package codechef

import java.io.IOException
import java.util.*

internal object CHEFWORK {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        val n = stdin.nextInt()
        val c = IntArray(n)
        for (i in 0 until n) c[i] = stdin.nextInt()
        val min = IntArray(4)
        Arrays.fill(min, 100000)
        for (i in 0 until n) {
            val t = stdin.nextInt()
            min[t] = Math.min(min[t], c[i])
        }
        println(if (min[1] + min[2] < min[3]) min[1] + min[2] else min[3])
        stdin.close()
    }
}