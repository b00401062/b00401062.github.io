package codechef

import java.io.IOException

object POSPREFS {
    private fun formula(x: Int): Double {
        return (Math.sqrt(1 + 4 * x) - 1) / 2
    }

    private fun solve(n: Int, k: Int): IntArray {
        val a = IntArray(n + 1)
        val m = if (k == n) n else formula((k + 1) * (k + 2) / 2).toInt()
        for (i in 1..m) {
            a[i] = i
        }
        for (i in m + 1..n) {
            a[i] = -i
        }
        if (m * m + m <= k * (k + 1) / 2) {
            a[k + 1] = k + 1
        }
        return a
    }

    @Throws(IOException::class)
    fun main(args: Array<String?>?) {
        val stdin = Scanner(System.`in`)
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            val n: Int = stdin.nextInt()
            val k: Int = stdin.nextInt()
            val a = solve(n, k)
            System.out.println(
                    Arrays
                            .stream(a)
                            .skip(1)
                            .mapToObj(Integer::toString)
                            .collect(Collectors.joining(" "))
            )
        }
        stdin.close()
    }
}