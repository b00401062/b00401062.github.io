package codechef

import java.io.IOException
import java.util.*

internal object SMRSTR {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var t = stdin.nextInt()
        while (t-- > 0) {
            var n = stdin.nextInt()
            var q = stdin.nextInt()
            var p: Long = 1
            while (n-- > 0 && p <= 1e9.toInt()) p *= stdin.nextInt().toLong()
            stdin.nextLine()
            while (q-- > 0) System.out.printf("%d ", stdin.nextInt() / p)
            println()
        }
        stdin.close()
    }
}