private fun getPrimesBelow(n: Int): IntArray {
    if (n <= 1) return intArrayOf()
    val marked = BooleanArray(n + 1)
    marked[0] = true
    marked[1] = true
    for (i in 2..n) {
        var p = i shl 1
        while (p < n) {
            marked[p] = true
            p += i
        }
    }
    val primes = mutableListOf<Int>()
    for (i in 0..n) {
        if (!marked[i]) {
            primes.add(i)
        }
    }
    return primes.toIntArray()
}

fun sumFourDivisors(nums: IntArray): Int {
    val maxNum = nums.maxOrNull()!!
    if (maxNum == 1) return 0
    var primes = getPrimesBelow(maxNum)
    var res = 0
    for (numIdx in nums.indices) {
        var num = nums[numIdx]
        val counts = IntArray(primes.size) { 1 }
        for ((primeIdx, prime) in primes.withIndex()) {
            if (num < prime) break
            while (num % prime == 0) {
                counts[primeIdx]++
                num /= prime
            }
        }
        if (counts.reduce(Int::times) == 4) {
            val factors = primes.zip(counts).filter { it.second > 1 }.map { it.first }
            res += when (factors.size) {
                2 -> 1 + factors[0] + factors[1] + factors[0] * factors[1]
                1 -> 1 + factors[0] + factors[0] * factors[0] + factors[0] * factors[0] * factors[0]
                else -> 0
            }
        }
    }
    return res
}
