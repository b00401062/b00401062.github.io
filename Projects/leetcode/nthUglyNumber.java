package leetcode

private val cache = mutableListOf(1, 2, 3, 4, 5, 6, 8, 9, 10, 12)

fun isUgly(i: Int): Boolean {
    var i = i
    val last = cache.last()
    while (i > last) {
        when {
            i % 5 == 0 -> i /= 5
            i % 3 == 0 -> i /= 3
            i % 2 == 0 -> i /= 2
            else -> return false
        }
    }
    return cache.binarySearch(i) >= 0
}

fun genUglyNumber() = sequence {
    var i = cache.last() + 1
    while (true) {
        if (isUgly(i)) {
            cache.add(i)
            yield(i)
        }
        i += 1
    }
}

fun nthUglyNumber(n: Int): Int {
    return when {
        cache.size >= n -> cache[n - 1]
        else -> genUglyNumber().take(n - cache.size).last()
    }
}
