package codechef

import java.util.Scanner

internal object NUMFACT {
    private fun getPrimesBelow(n: Int): IntArray {
        val marked = BooleanArray(n)
        marked[0] = true
        marked[1] = true
        for (i in 2 until n) {
            var p = i shl 1
            while (p < n) {
                marked[p] = true
                p += i
            }
        }
        val primes = mutableListOf<Int>()
        for (i in 0 until n) {
            if (!marked[i]) {
                primes.add(i)
            }
        }
        return primes.toIntArray()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var T = stdin.nextInt()
        var primes = getPrimesBelow(1000000)
        while (T-- > 0) {
            val N = stdin.nextInt()
            val A = IntArray(N) { stdin.nextInt() }
            val counts = IntArray(primes.size) { 1 }
            for (a in A) {
                var a = a
                for ((i, prime) in primes.withIndex()) {
                    if (a < prime) break
                    while (a % prime == 0) {
                        counts[i]++
                        a /= prime
                    }
                }
            }
            val count = counts.reduce(Int::times)
            println(count)
        }
        stdin.close()
    }
}
