package leetcode

import java.util.*

private class Graph(p: String) {

    private data class Edge(val s: Int, val t: Int, val w: Char? = null)
    private data class Node(
        val edges: MutableList<Edge> = mutableListOf(),
        var visited: Boolean = false
    )

    private val nodes: MutableList<Node> = mutableListOf()

    private fun addNode(): Int {
        nodes.add(Node())
        return nodes.lastIndex
    }

    private fun addEdge(s: Int, t: Int, w: Char? = null) {
        nodes[s].edges.add(Edge(s, t, w))
    }

    private fun bfs(set: Set<Int>): Set<Int> {
        nodes.forEach { it.visited = false }
        val queue = LinkedList<Int>(set)
        while (queue.isNotEmpty()) {
            val n = queue.removeFirst()
            nodes[n].visited = true
            for (e in nodes[n].edges)
                if (e.w == null)
                    queue.add(e.t)
        }
        return nodes.indices.filter { nodes[it].visited }.toSet()
    }

    init {
        addNode()
        var i = 0
        while (i < p.length) {
            if (i < p.lastIndex && p[i + 1] == '*') {
                val n1 = addNode()
                val n2 = addNode()
                val n3 = addNode()
                val n0 = n1 - 1
                addEdge(n0, n1)
                addEdge(n0, n3)
                addEdge(n1, n2, p[i])
                addEdge(n2, n1)
                addEdge(n2, n3)
                i += 2
            } else {
                val n1 = addNode()
                val n0 = n1 - 1
                addEdge(n0, n1, p[i])
                i++
            }
        }
    }

    fun match(s: String): Boolean {
        var set = bfs(setOf(0))
        for (c in s) {
            val tmp = mutableSetOf<Int>()
            for (n in set)
                for (e in nodes[n].edges)
                    if (e.w == c || e.w == '.')
                        tmp.add(e.t)
            if (tmp.isEmpty())
                return false
            set = bfs(tmp)
        }
        return set.contains(nodes.lastIndex)
    }
}

fun isMatch(s: String, p: String): Boolean {
    return Graph(p).match(s)
}
