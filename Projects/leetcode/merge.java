package leetcode

import kotlin.math.max

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return arrayOf()
    intervals.sortBy { it[0] }
    val mergedIntervals: MutableList<IntArray> = mutableListOf()
    var lowerLimit = intervals[0][0]
    var upperLimit = intervals[0][1]
    for (interval in intervals) {
        if (interval[0] > upperLimit) {
            mergedIntervals.add(intArrayOf(lowerLimit, upperLimit))
            lowerLimit = interval[0]
            upperLimit = interval[1]
        } else {
            upperLimit = max(upperLimit, interval[1])
        }
    }
    mergedIntervals.add(intArrayOf(lowerLimit, upperLimit))
    return mergedIntervals.toTypedArray()
}