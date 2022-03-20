package codechef

import java.io.IOException
import java.util.*

internal object BSTOPS {
    private fun insert(root: Node?, x: Int, p: Long): Node {
        if (root == null) {
            println(p)
            return Node(x, p)
        } else if (x < root.x) {
            root.lt = insert(root.lt, x, p * 2)
        } else if (x > root.x) {
            root.rt = insert(root.rt, x, p * 2 + 1)
        }
        return root
    }

    private fun delete(root: Node?, x: Int): Node? {
        if (x < root!!.x) {
            root.lt = delete(root.lt, x)
        } else if (x > root.x) {
            root.rt = delete(root.rt, x)
        } else {
            println(root.p)
            if (root.lt == null) {
                return root.rt
            } else if (root.rt == null) {
                return root.lt
            } else {
                var successor = root.rt
                while (successor!!.lt != null) successor = successor.lt
                root.x = successor.x
                root.rt = delete(root.rt, successor.x)
            }
        }
        return root
    }

    @Throws(IOException::class)
    @JvmStatic
    fun main(args: Array<String>) {
        val stdin = Scanner(System.`in`)
        var n = stdin.nextInt()
        var root: Node? = null
        while (n-- > 0) {
            val c = stdin.next()[0]
            val x = stdin.nextInt()
            when (c) {
                'i' -> root = insert(root, x, 1)
                'd' -> root = delete(root, x)
            }
        }
        stdin.close()
    }

    private class Node internal constructor(var x: Int, var p: Long) {
        var lt: Node? = null
        var rt: Node? = null

    }
}