package codechef

import java.io.IOException
import java.util.*

internal object XORAGN {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var t = stdin.nextLine().toInt()
        while (t-- > 0) {
            stdin.nextLine().toInt()
            println(
                stdin.nextLine()
                .split(" ")
                .map(String::toInt)
                .map { x: Int -> x * 2 }
                .reduce { x1: Int, x2: Int -> x1 xor x2 }
            )
        }
        stdin.close()
    }
}
