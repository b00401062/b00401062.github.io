package codechef

import java.io.IOException
import java.util.*
import kotlin.math.max
import kotlin.math.min

internal object RUNDIR {
    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var t = stdin.nextInt()
        while (t-- > 0) {
            val n = stdin.nextInt()
            val children = Array(n) {
                Child(stdin.nextInt(), stdin.nextInt())
            }
            var LT = Double.POSITIVE_INFINITY
            var RT = Double.POSITIVE_INFINITY
            children.sortBy(Child::x)
            for (i in 1 until n) {
                val lt = max(
                    min(LT, children[i].setDir(Dir.LT).time(children[i - 1].setDir(Dir.LT))),
                    min(RT, children[i].setDir(Dir.LT).time(children[i - 1].setDir(Dir.RT)))
                )
                val rt = max(
                    min(LT, children[i].setDir(Dir.RT).time(children[i - 1].setDir(Dir.LT))),
                    min(RT, children[i].setDir(Dir.RT).time(children[i - 1].setDir(Dir.RT)))
                )
                LT = lt
                RT = rt
            }
            val optimal = Math.max(LT, RT)
            println(if (optimal == Double.POSITIVE_INFINITY) -1 else optimal)
        }
        stdin.close()
    }

    private enum class Dir(private val dir: Int) {
        LT(-1), RT(1);

        fun toInt(): Int {
            return dir
        }

    }

    private class Child internal constructor(var x: Int, var v: Int) {
        var dir: Dir? = null
        fun setDir(dir: Dir?): Child {
            this.dir = dir
            return this
        }

        fun time(that: Child): Double {
            val x = that.x - x
            val v = that.v * that.dir!!.toInt() - v * dir!!.toInt()
            if (v == 0) return Double.POSITIVE_INFINITY
            val time = x.toDouble() / v
            return if (time > 0) Double.POSITIVE_INFINITY else -time
        }

    }
}