package codechef

import java.io.*

internal object EVENPSUM {
    private fun evenpsum(a: Int, b: Int): Long {
        val evenCountInA = (a / 2).toLong()
        val oddCountInA = ((a + 1) / 2).toLong()
        val evenCountInB = (b / 2).toLong()
        val oddCountInB = ((b + 1) / 2).toLong()
        return oddCountInA * oddCountInB + evenCountInA * evenCountInB
    }

    @Throws(IOException::class)
    fun main(args: Array<String?>?) {
        val stdin = Scanner(BufferedReader(InputStreamReader(System.`in`)))
        val stdout = BufferedWriter(OutputStreamWriter(System.out))
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            val a: Int = stdin.nextInt()
            val b: Int = stdin.nextInt()
            val pairCount = evenpsum(a, b)
            stdout.write(String.format("%d\n", pairCount))
        }
        stdin.close()
        stdout.flush()
        stdout.close()
    }
}