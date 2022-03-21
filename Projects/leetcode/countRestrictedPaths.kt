package leetcode

import java.util.ArrayList
import java.util.Comparator
import java.util.PriorityQueue

private fun shortestPath(adjList: List<Node>, beginNode: Node, endNode: Node) {
    val pairs = PriorityQueue(
        adjList.size,
        Comparator.comparingInt { obj: Pair -> obj.distance() }
    )
    beginNode.distance = 0
    beginNode.pathCount = 1
    pairs.add(Pair(beginNode.id, 0))
    while (true) {
        val pair = pairs.poll()
        val currNode = adjList[pair.nodeID]
        if (currNode.processed) continue
        currNode.pathCount = ((currNode.edges.stream().map { obj: Edge -> obj.headNode() }
            .filter { obj: Node -> obj.processed() }.filter { node: Node -> node.distance < currNode.distance }
            .mapToLong { obj: Node ->
                obj.pathCount()
                    .toLong()
            }.sum() + currNode.pathCount) % 1000000007).toInt()
        currNode.processed = true
        if (endNode.processed) return
        for (edge in currNode.edges) {
            val nextNode = edge.headNode
            if (nextNode.processed) continue
            val distance = currNode.distance + edge.weight
            if (nextNode.distance <= distance) continue
            nextNode.distance = distance
            pairs.add(Pair(nextNode.id, distance))
        }
    }
}

fun countRestrictedPaths(n: Int, edges: Array<IntArray>): Int {
    val adjList: MutableList<Node> = ArrayList(n + 1)
    for (i in 0..n) {
        adjList.add(Node(i))
    }
    for (edge in edges) {
        adjList[edge[0]].insertEdge(adjList[edge[1]], edge[2])
        adjList[edge[1]].insertEdge(adjList[edge[0]], edge[2])
    }
    shortestPath(adjList, adjList[n], adjList[1])
    return adjList[1].pathCount
}

private class Node internal constructor(val id: Int) {
    val edges: MutableList<Edge> = ArrayList()
    var distance = Int.MAX_VALUE
    var pathCount = 0
    var processed = false
    fun distance(): Int {
        return distance
    }

    fun pathCount(): Int {
        return pathCount
    }

    fun processed(): Boolean {
        return processed
    }

    fun insertEdge(node: Node, weight: Int) {
        edges.add(Edge(this, node, weight))
    }
}

private class Edge internal constructor(val tailNode: Node, val headNode: Node, val weight: Int) {
    fun headNode(): Node {
        return headNode
    }
}

private class Pair internal constructor(val nodeID: Int, val distance: Int) {
    fun distance(): Int {
        return distance
    }
}
