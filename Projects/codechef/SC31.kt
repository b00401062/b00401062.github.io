package codechef

import java.util.*

object SC31 {
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var T = stdin.nextInt()
        while (T-- > 0) {
            var N = stdin.nextInt()
            var res = 0
            while (N-- > 0) {
                res = res xor stdin.nextInt(2)
            }
            println(res.toString(2).filter('1'::equals).count())
        }
    }
}
