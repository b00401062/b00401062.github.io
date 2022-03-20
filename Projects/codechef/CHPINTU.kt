package codechef

import kotlin.Throws
import codechef.KNPSK.Record

internal object CHPINTU {
    fun main(args: Array<String?>?) {
        val stdin = Scanner(System.`in`)
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            val n: Int = stdin.nextInt()
            val m: Int = stdin.nextInt()
            val fs = IntArray(n)
            val isAvailables = BooleanArray(m)
            for (i in 0 until n) {
                val f: Int = stdin.nextInt()
                fs[i] = f
                isAvailables[f - 1] = true
            }
            val costs = IntArray(m)
            for (i in 0 until n) {
                costs[fs[i] - 1] += stdin.nextInt()
            }
            var minCost: Int = Integer.MAX_VALUE
            for (i in 0 until m) {
                if (!isAvailables[i]) continue
                minCost = Math.min(minCost, costs[i])
            }
            System.out.println(minCost)
        }
        stdin.close()
    }
}