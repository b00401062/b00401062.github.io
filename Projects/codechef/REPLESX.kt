package codechef

import java.io.*

internal object REPLESX {
    @Throws(IOException::class)
    fun main(args: Array<String?>?) {
        val stdin = Scanner(BufferedReader(InputStreamReader(System.`in`)))
        var t: Int = stdin.nextInt()
        while (t-- > 0) {
            var n: Int = stdin.nextInt()
            val x: Int = stdin.nextInt()
            val p: Int = stdin.nextInt()
            val k: Int = stdin.nextInt()
            var st_cnt = 0
            var eq_cnt = 0
            while (n-- > 0) {
                val a: Int = stdin.nextInt()
                if (a < x) st_cnt++ else if (a == x) eq_cnt++
            }
            if (p <= st_cnt && k <= p) {
                System.out.println(st_cnt - p + 1)
            } else if (st_cnt < p && p <= st_cnt + eq_cnt) {
                System.out.println(0)
            } else if (st_cnt + eq_cnt < p && p <= k) {
                System.out.println(p - st_cnt - eq_cnt)
            } else {
                System.out.println(-1)
            }
        }
        stdin.close()
    }
}