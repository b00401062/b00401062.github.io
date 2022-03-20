package codechef

import java.util.Scanner

internal object BINIM {
    private const val ZERO = '0'.toInt()
    private const val ONE = '1'.toInt()
    private val PLAYERS = arrayOf("Dee", "Dum")

    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var T = stdin.nextInt()
        while (T-- > 0) {
            var N = stdin.nextInt()
            val turn = if (stdin.next() == "Dum") 1 else 0
            val counts = IntArray(2)
            while (N-- > 0) {
                val stack = stdin.next()
                val who = if (stack[0] == '1') ONE else ZERO
                counts[stack[0] - '0'] += stack.filter(who::equals).count()
            }
            println(when {
                counts[turn] > counts[1 - turn] -> PLAYERS[turn]
                else -> PLAYERS[1 - turn]
            })
        }
        stdin.close()
    }
}
