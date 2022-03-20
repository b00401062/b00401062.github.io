package codechef

import java.io.*

internal object CVDRUN {
    private fun gcd(n: Int, k: Int): Int {
        var max: Int = Math.max(n, k)
        var min: Int = Math.min(n, k)
        while (max % min != 0) {
            val tmp = max % min
            max = min
            min = tmp
        }
        return min
    }

    @Throws(IOException::class)
    fun main(args: Array<String?>?) {
        val stdin = Scanner(BufferedReader(InputStreamReader(System.`in`)))
        val stdout = BufferedWriter(OutputStreamWriter(System.out))
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            val n: Int = stdin.nextInt()
            val k: Int = stdin.nextInt()
            val x: Int = stdin.nextInt()
            val y: Int = stdin.nextInt()
            val isReachable = if (k == 0) x == y else Math.abs(x - y) % gcd(n, k) === 0
            System.out.println(if (isReachable) "YES" else "NO")
        }
        stdin.close()
        stdout.flush()
        stdout.close()
    }
}