package codechef

import java.util.*
import kotlin.math.max

@Suppress("NAME_SHADOWING", "UNUSED_PARAMETER")
class BST<K : Comparable<K>, V> {
    private var root: Node? = null

    private inner class Node(var k: K, var v: V, var color: Boolean, var size: Int, var lt: Node? = null, var rt: Node? = null)

    private fun isRed(x: Node?): Boolean {
        return x?.color == RED
    }

    val size: Int
        get() = size(root)

    private fun size(x: Node?): Int {
        return x?.size ?: 0
    }

    val isEmpty: Boolean
        get() = root == null

    operator fun get(k: K): V? {
        return get(root, k)
    }

    private operator fun get(x: Node?, k: K): V? {
        var x = x
        while (x != null) {
            x = when {
                k < x.k -> x.lt
                k > x.k -> x.rt
                else -> return x.v
            }
        }
        return null
    }

    operator fun contains(k: K): Boolean {
        return get(k) != null
    }

    operator fun set(k: K, v: V?) {
        if (v == null) {
            delete(k)
            return
        }
        root = set(root, k, v)
        root!!.color = BLACK
    }

    private operator fun set(h: Node?, k: K, v: V): Node {
        var h = h ?: return Node(k, v, RED, 1)
        when {
            k < h.k -> h.lt = set(h.lt, k, v)
            k > h.k -> h.rt = set(h.rt, k, v)
            else -> h.v = v
        }
        if (isRed(h.rt) && !isRed(h.lt)) h = rotateLeft(h)
        if (isRed(h.lt) && isRed(h.lt!!.lt)) h = rotateRight(h)
        if (isRed(h.lt) && isRed(h.rt)) flipColors(h)
        h.size = size(h.lt) + size(h.rt) + 1
        return h
    }

    fun delete(k: K) {
        if (!contains(k)) return
        if (!isRed(root!!.lt) && !isRed(root!!.rt)) root!!.color = RED
        root = delete(root!!, k)
        if (!isEmpty) root!!.color = BLACK
    }

    private fun delete(h: Node, k: K): Node? {
        var h = h
        if (k < h.k) {
            if (!isRed(h.lt) && !isRed(h.lt!!.lt)) h = moveRedLeft(h)
            h.lt = delete(h.lt!!, k)
        } else {
            if (isRed(h.lt)) h = rotateRight(h)
            if (k == h.k && h.rt == null) return null
            if (!isRed(h.rt) && !isRed(h.rt!!.lt)) h = moveRedRight(h)
            if (k == h.k) {
                val x = min(h.rt!!)
                h.k = x.k
                h.v = x.v
                h.rt = deleteMin(h.rt!!)
            } else h.rt = delete(h.rt!!, k)
        }
        return balance(h)
    }

    fun deleteMin() {
        if (isEmpty) throw NoSuchElementException()
        if (!isRed(root!!.lt) && !isRed(root!!.rt)) root!!.color = RED
        root = deleteMin(root!!)
        if (!isEmpty) root!!.color = BLACK
    }

    private fun deleteMin(h: Node): Node? {
        var h = h
        if (h.lt == null) return null
        if (!isRed(h.lt) && !isRed(h.lt!!.lt)) h = moveRedLeft(h)
        h.lt = deleteMin(h.lt!!)
        return balance(h)
    }

    fun deleteMax() {
        if (isEmpty) throw NoSuchElementException()
        if (!isRed(root!!.lt) && !isRed(root!!.rt)) root!!.color = RED
        root = deleteMax(root!!)
        if (!isEmpty) root!!.color = BLACK
    }

    private fun deleteMax(h: Node): Node? {
        var h = h
        if (isRed(h.lt)) h = rotateRight(h)
        if (h.rt == null) return null
        if (!isRed(h.rt) && !isRed(h.rt!!.lt)) h = moveRedRight(h)
        h.rt = deleteMax(h.rt!!)
        return balance(h)
    }

    private fun rotateRight(h: Node): Node {
        val x = h.lt!!
        h.lt = x.rt
        x.rt = h
        x.color = x.rt!!.color
        x.rt!!.color = RED
        x.size = h.size
        h.size = size(h.lt) + size(h.rt) + 1
        return x
    }

    private fun rotateLeft(h: Node): Node {
        val x = h.rt!!
        h.rt = x.lt
        x.lt = h
        x.color = x.lt!!.color
        x.lt!!.color = RED
        x.size = h.size
        h.size = size(h.lt) + size(h.rt) + 1
        return x
    }

    private fun flipColors(h: Node) {
        h.color = !h.color
        h.lt!!.color = !h.lt!!.color
        h.rt!!.color = !h.rt!!.color
    }

    private fun moveRedLeft(h: Node): Node {
        var h = h
        flipColors(h)
        if (isRed(h.rt!!.lt)) {
            h.rt = rotateRight(h.rt!!)
            h = rotateLeft(h)
            flipColors(h)
        }
        return h
    }

    private fun moveRedRight(h: Node): Node {
        var h = h
        flipColors(h)
        if (isRed(h.lt!!.lt)) {
            h = rotateRight(h)
            flipColors(h)
        }
        return h
    }

    private fun balance(h: Node): Node {
        var h = h
        if (isRed(h.rt)) h = rotateLeft(h)
        if (isRed(h.lt) && isRed(h.lt!!.lt)) h = rotateRight(h)
        if (isRed(h.lt) && isRed(h.rt)) flipColors(h)
        h.size = size(h.lt) + size(h.rt) + 1
        return h
    }

    val height: Int
        get() = height(root)

    private fun height(x: Node?): Int {
        return if (x == null) -1 else 1 + max(height(x.lt), height(x.rt))
    }

    fun min(): K {
        if (isEmpty) throw NoSuchElementException()
        return min(root!!).k
    }

    private fun min(x: Node): Node {
        return if (x.lt == null) x else min(x.lt!!)
    }

    fun max(): K {
        if (isEmpty) throw NoSuchElementException()
        return max(root!!).k
    }

    private fun max(x: Node): Node {
        return if (x.rt == null) x else max(x.rt!!)
    }

    fun floor(k: K): K {
        val x = floor(root, k)
        return x?.k ?: throw NoSuchElementException()
    }

    private fun floor(x: Node?, k: K): Node? {
        return when {
            x == null -> null
            k == x.k -> x
            k < x.k -> floor(x.lt, k)
            else -> floor(x.rt, k) ?: x
        }
    }

    fun ceiling(k: K): K {
        val x = ceiling(root, k)
        return x?.k ?: throw NoSuchElementException()
    }

    private fun ceiling(x: Node?, k: K): Node? {
        return when {
            x == null -> null
            k == x.k -> x
            k > x.k -> ceiling(x.rt, k)
            else -> ceiling(x.lt, k) ?: x
        }
    }

    fun select(k: Int): K {
        require(k in 0 until size)
        val x = select(root!!, k)
        return x!!.k
    }

    private fun select(x: Node, k: Int): Node? {
        val t = size(x.lt)
        return when {
            t > k -> select(x.lt!!, k)
            t < k -> select(x.rt!!, k - t - 1)
            else -> x
        }
    }

    fun rank(k: K): Int {
        return rank(root, k)
    }

    private fun rank(x: Node?, k: K): Int {
        return when {
            x == null -> 0
            k < x.k -> rank(x.lt, k)
            k > x.k -> 1 + size(x.lt) + rank(x.rt, k)
            else -> size(x.lt)
        }
    }

    val keys: Iterable<K>
        get() = if (isEmpty) ArrayDeque() else keys(min(), max(), true)

    fun keys(lo: K, hi: K, inclusive: Boolean = false): Iterable<K> {
        val queue: Queue<K> = ArrayDeque()
        keys(root, queue, lo, hi)
        if (inclusive) queue.add(hi)
        return queue
    }

    private fun keys(x: Node?, queue: Queue<K>, lo: K, hi: K) {
        if (x == null) return
        if (lo < x.k) keys(x.lt, queue, lo, hi)
        if (lo <= x.k && hi > x.k) queue.add(x.k)
        if (hi >= x.k) keys(x.rt, queue, lo, hi)
    }

    fun size(lo: K, hi: K): Int {
        if (lo >= hi) return 0
        return rank(hi) - rank(lo)
    }

    val isBST: Boolean
        get() = isBST(root, null, null)

    private fun isBST(x: Node?, min: K?, max: K?): Boolean {
        return when {
            x == null -> true
            min != null && x.k <= min -> false
            max != null && x.k >= max -> false
            else -> isBST(x.lt, min, x.k) && isBST(x.rt, x.k, max)
        }
    }

    val isSizeConsistent: Boolean
        get() = isSizeConsistent(root)

    private fun isSizeConsistent(x: Node?): Boolean {
        if (x == null) return true
        return when {
            x.size != size(x.lt) + size(x.rt) + 1 -> false
            else -> isSizeConsistent(x.lt) && isSizeConsistent(x.rt)
        }
    }

    val isRankConsistent: Boolean
        get() {
            for (i in 0 until size) if (i != rank(select(i))) return false
            for (k in keys) if (k != select(rank(k))) return false
            return true
        }

    val is23: Boolean
        get() = is23(root)

    private fun is23(x: Node?): Boolean {
        if (x == null) return true
        if (isRed(x.rt)) return false
        return when {
            x !== root && isRed(x) && isRed(x.lt) -> false
            else -> is23(x.lt) && is23(x.rt)
        }
    }

    val isBalanced: Boolean
        get() {
            var black = 0
            var x = root
            while (x != null) {
                if (!isRed(x)) black++
                x = x!!.lt
            }
            return isBalanced(root, black)
        }

    private fun isBalanced(x: Node?, black: Int): Boolean {
        var black = black
        if (x == null) return black == 0
        if (!isRed(x)) black--
        return isBalanced(x.lt, black) && isBalanced(x.rt, black)
    }

    companion object {
        private const val RED = true
        private const val BLACK = false
    }
}
