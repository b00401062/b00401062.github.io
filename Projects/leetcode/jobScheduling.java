package leetcode

import java.util.*

private fun prevJobIdx(jobs: Array<Job?>, i: Int): Int {
    var i = i
    val job = jobs[i]
    while (--i >= 0 && jobs[i]!!.endTime > job!!.startTime);
    return i
}

fun jobScheduling(startTime: IntArray, endTime: IntArray, profit: IntArray): Int {
    val n = profit.size
    val jobs = arrayOfNulls<Job>(n)
    for (i in 0 until n) {
        jobs[i] = Job(startTime[i], endTime[i], profit[i])
    }
    Arrays.sort(jobs, Comparator.comparingInt { obj: Job? -> obj!!.endTime() })
    val cache = IntArray(n)
    cache[0] = jobs[0]!!.profit
    for (i in 1 until n) {
        val job = jobs[i]
        val prevJobIdx = prevJobIdx(jobs, i)
        cache[i] = Math.max(cache[i - 1], job!!.profit + if (prevJobIdx == -1) 0 else cache[prevJobIdx])
    }
    return cache[n - 1]
}

private class Job(val startTime: Int, val endTime: Int, val profit: Int) {
    fun endTime(): Int {
        return endTime
    }
}
