package codechef

import kotlin.Throws
import codechef.KNPSK.Record

internal object ENGXOR {
    fun main(args: Array<String?>?) {
        val stdin = Scanner(BufferedReader(InputStreamReader(System.`in`)))
        val stdout = BufferedWriter(OutputStreamWriter(System.out))
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            val n: Int = stdin.nextInt()
            var q: Int = stdin.nextInt()
            var lastA = 0
            var nOdds = 0
            for (i in 0 until n) {
                lastA = stdin.nextInt()
                val cardinality: Int = Integer.bitCount(lastA)
                nOdds += cardinality % 2
            }
            val lastACardinality: Int = Integer.bitCount(lastA)
            while (q-- > 0) {
                val p: Int = stdin.nextInt()
                val cardinality: Int = Integer.bitCount(p xor lastA)
                val isSame = cardinality % 2 == lastACardinality % 2
                val resNOdds = if (isSame) nOdds else n - nOdds
                stdout.write(String.format("%d %d\n", n - resNOdds, resNOdds))
            }
        }
        stdin.close()
        stdout.flush()
        stdout.close()
    }
}