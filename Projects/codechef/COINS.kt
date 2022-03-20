package codechef

import java.util.*
import kotlin.math.max

object COINS {

    private val map = mutableMapOf(0 to 0L)

    private fun exchange(n: Int): Long = when (n) {
        in map -> map[n]!!
        else -> {
            val subtotal2 = exchange(n / 2)
            val subtotal3 = exchange(n / 3)
            val subtotal4 = exchange(n / 4)
            val total = subtotal2 + subtotal3 + subtotal4
            map[n] = max(n.toLong(), total)
            map[n]!!
        }
    }

    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        while (stdin.hasNextLine()) {
            val n = stdin.nextLine().toInt()
            println(exchange(n))
        }
        stdin.close()
    }
}