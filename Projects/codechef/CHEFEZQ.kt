package codechef

import java.io.*

internal object CHEFEZQ {
    @Throws(IOException::class)
    fun main(args: Array<String?>?) {
        val stdin = Scanner(BufferedReader(InputStreamReader(System.`in`)))
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            val n: Int = stdin.nextInt()
            val k: Int = stdin.nextInt()
            var debt: Long = 0
            for (i in 1..n) {
                val q: Int = stdin.nextInt()
                debt += (q - k).toLong()
                if (debt < 0) {
                    stdin.nextLine()
                    System.out.println(i)
                    break
                }
            }
            if (debt < 0) continue
            System.out.println(n + debt / k + 1)
        }
        stdin.close()
    }
}