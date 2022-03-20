package codechef

import java.util.*

@Suppress("NAME_SHADOWING", "UNUSED_PARAMETER")
internal object FLIPCOIN {
    private val tree = BST<Int, Boolean>()

    init {
        tree[Int.MIN_VALUE] = false
    }

    private fun flip(op: Int, lt: Int, rt: Int) {
        var lt = lt
        when (op) {
            0 -> {
                tree[lt] = if (lt in tree) null else tree[tree.floor(lt)]
                tree[rt] = if (rt in tree) null else tree[tree.floor(rt)]
                for (k in tree.keys(lt, rt)) {
                    tree[k] = !tree[k]!!
                }
            }
            1 -> {
                var sum = 0
                for (k in tree.keys(lt, rt)) {
                    if (!tree[k]!!) {
                        sum += k - lt
                    }
                    lt = k
                }
                if (tree.contains(lt) && tree[lt]!!) {
                    sum += rt - lt
                }
                println(sum)
            }
            else -> throw IllegalArgumentException()
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        val n = stdin.nextInt()
        var q = stdin.nextInt()
        while (q-- > 0) {
            val op = stdin.nextInt()
            val lt = stdin.nextInt()
            val rt = stdin.nextInt()
            flip(op, lt, rt + 1)
        }
        stdin.close()
    }
}
