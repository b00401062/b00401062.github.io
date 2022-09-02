package leetcode

fun isHappy(n: Int): Boolean {
    var curr = n
    val seen = HashSet<Int>()
    while (curr != 1 && curr !in seen) {
        seen.add(curr)
        var next = 0
        while (curr != 0) {
            val digit = curr % 10
            curr /= 10
            next += digit * digit
        }
        curr = next
    }
    return curr == 1
}
