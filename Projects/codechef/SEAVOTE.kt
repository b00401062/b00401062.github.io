package codechef

import java.util.Arrays

internal object SEAVOTE {
    private fun solve(bs: IntArray): Boolean {
        val nPositives = Arrays.stream(bs).filter { x -> x > 0 }.count() as Int
        val sum: Int = Arrays.stream(bs).reduce { x1, x2 -> x1 + x2 }.getAsInt()
        return 100 > sum - nPositives && 100 <= sum
    }

    fun main(args: Array<String?>?) {
        val stdin = Scanner(System.`in`)
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            val n: Int = stdin.nextInt()
            val bs = IntArray(n)
            for (i in 0 until n) {
                bs[i] = stdin.nextInt()
            }
            val res = solve(bs)
            System.out.println(if (res) "YES" else "NO")
        }
        stdin.close()
    }
}