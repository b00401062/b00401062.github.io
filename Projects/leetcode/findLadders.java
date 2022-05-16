package leetcode

import java.util.*

private fun distance(w1: String, w2: String): Int {
    assert(w1.length == w2.length)
    val n = w1.length
    var distance = 0
    for (i in 0 until n) {
        if (w1[i] == w2[i]) continue
        distance++
    }
    return distance
}

private fun ladder(stack: Stack<Node>): List<String?> {
    val ladder: MutableList<String?> = ArrayList()
    ladder.addAll(stack.map { obj: Node -> obj.word }.toList())
    ladder.reverse()
    return ladder
}

private fun traverse(beginWord: String, ladders: MutableList<List<String?>>, stack: Stack<Node>) {
    if (stack.peek().word === beginWord) {
        ladders.add(ladder(stack))
        return
    }
    for (parent in stack.peek().parents) {
        stack.push(parent)
        traverse(beginWord, ladders, stack)
        stack.pop()
    }
}

fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String?>> {
    val n = wordList.size
    val nodes = wordList.map { word: String -> Node(word) }
    val beginNode = Node(beginWord)
    val endNodeIdx = wordList.indexOf(endWord)
    if (endNodeIdx == -1) return ArrayList()
    val endNode = nodes[endNodeIdx]
    for (i in 0 until n) {
        if (distance(beginWord, wordList[i]) != 1) continue
        beginNode.neighbors.add(nodes[i])
        nodes[i].neighbors.add(beginNode)
    }
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (distance(wordList[i], wordList[j]) != 1) continue
            nodes[i].neighbors.add(nodes[j])
            nodes[j].neighbors.add(nodes[i])
        }
    }
    val queue: Queue<Node> = LinkedList()
    queue.add(beginNode.color(Color.GRAY).distance(0))
    while (!queue.isEmpty()) {
        val curNode = queue.remove()
        if (curNode === endNode) break
        for (neighbor in curNode.neighbors) {
            if (neighbor.color == Color.BLACK) continue
            if (neighbor.distance < curNode.distance + 1) continue
            neighbor.distance(curNode.distance + 1)
            neighbor.parents.add(curNode)
            if (neighbor.color == Color.GRAY) continue
            queue.add(neighbor.color(Color.GRAY))
        }
    }
    val ladders: MutableList<List<String?>> = ArrayList()
    val stack: Stack<Node> = Stack()
    stack.push(endNode)
    traverse(beginWord, ladders, stack)
    return ladders
}

private enum class Color {
    WHITE, GRAY, BLACK
}

private class Node(val word: String) {
    var color = Color.WHITE
    var distance = Int.MAX_VALUE
    val neighbors: MutableList<Node> = ArrayList()
    val parents: MutableList<Node> = ArrayList()

    fun color(color: Color): Node {
        this.color = color
        return this
    }

    fun distance(distance: Int): Node {
        this.distance = distance
        return this
    }
}
