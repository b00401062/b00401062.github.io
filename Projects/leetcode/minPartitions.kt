package leetcode

fun minPartitions(n: String): Int {
    return n.chars().map { x: Int -> x - '0'.code }.max().asInt
}
