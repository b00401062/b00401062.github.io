package leetcode

import java.util.HashMap
import java.util.ArrayList

private fun insertEdge(edges: MutableMap<Int, MutableList<Int>>, v0: Int, v1: Int) {
    val neighbors = edges.getOrDefault(v0, ArrayList())
    neighbors.add(v1)
    edges.putIfAbsent(v0, neighbors)
}

fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
    val edges: MutableMap<Int, MutableList<Int>> = HashMap()
    for (pair in adjacentPairs) {
        insertEdge(edges, pair[0], pair[1])
        insertEdge(edges, pair[1], pair[0])
    }
    val head = edges.entries.stream()
        .filter { (_, value): Map.Entry<Int, List<Int>> -> value.size == 1 }
        .findFirst().get().key
    val restoredArray = IntArray(adjacentPairs.size + 1)
    restoredArray[0] = head
    for (i in 1 until restoredArray.size) {
        val neighbors: List<Int> = edges[restoredArray[i - 1]]!!
        restoredArray[i] =
            if (neighbors.size == 1) neighbors[0] else neighbors[0] xor neighbors[1] xor restoredArray[i - 2]
    }
    return restoredArray
}
