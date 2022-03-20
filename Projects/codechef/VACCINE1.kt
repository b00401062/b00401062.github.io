package codechef

import java.io.IOException
import java.util.Scanner

data class Company(val d: Int, val v: Int)

fun vaccine1(d1: Int, v1: Int, d2: Int, v2: Int, p: Int): Int {
    val companies = mutableListOf(Company(d1, v1), Company(d2, v2))
    companies.sortBy { it.d }
    companies.add(Company(Int.MAX_VALUE, 0))
    var v = 0
    var deficit = p
    for ((curr, next) in companies.zipWithNext()) {
        v += curr.v
        if (curr.d == next.d) continue
        val delta = if (next.d == Int.MAX_VALUE) Int.MAX_VALUE else (next.d - curr.d) * v
        if (deficit > delta) {
            deficit -= delta
        } else {
            return curr.d + (deficit - 1) / v
        }
    }
    return -1
}

fun main(args: Array<String>) {
    val stdin = Scanner(System.`in`)
    val d1 = stdin.nextInt()
    val v1 = stdin.nextInt()
    val d2 = stdin.nextInt()
    val v2 = stdin.nextInt()
    val p = stdin.nextInt()
    val d = vaccine1(d1, v1, d2, v2, p)
    println(d)
    stdin.close()
}
