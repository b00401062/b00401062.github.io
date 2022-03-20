package codechef

import java.io.IOException
import java.util.*

internal object H1 {
    private val primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17)
    private val pairs = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(1, 2),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(6, 7),
        intArrayOf(7, 8),
        intArrayOf(0, 3),
        intArrayOf(1, 4),
        intArrayOf(2, 5),
        intArrayOf(3, 6),
        intArrayOf(4, 7),
        intArrayOf(5, 8)
    )
    private val steps: MutableMap<String, Int> = HashMap()
    private fun bfs(s: String) {
        steps[s] = 0
        val queue: Queue<String> = LinkedList<String>()
        queue.add(s)
        while (queue.size > 0) {
            val u = queue.remove()
            val d = steps[u]!!
            for (pair in pairs) {
                val a = u[pair[0]]
                val b = u[pair[1]]
                if (!primes.contains((a - '0') + (b - '0'))) continue
                val v = u.replace(a, '@').replace(b, a).replace('@', b)
                if (steps.containsKey(v)) continue
                steps[v] = d + 1
                queue.add(v)
            }
        }
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        bfs("123456789")
        var t = stdin.nextLine().toInt()
        while (t-- > 0) {
            stdin.nextLine()
            var puzzle = ""
            for (i in 0..2) {
                puzzle += stdin.nextLine().replace(" ", "")
            }
            println(if (steps.containsKey(puzzle)) steps[puzzle] else -1)
        }
        stdin.close()
    }
}