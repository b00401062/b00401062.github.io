import kotlin.math.max
import kotlin.math.min

fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
    val ans = mutableListOf<IntArray>()
    var curInterval = newInterval
    for (i in intervals.indices) {
        if (curInterval[1] < intervals[i][0]) {
            ans.add(curInterval)
            curInterval = intervals[i]
        } else if (intervals[i][1] < curInterval[0]) {
            ans.add(intervals[i])
        } else {
            curInterval[0] = min(intervals[i][0], newInterval[0])
            curInterval[1] = max(intervals[i][1], newInterval[1])
        }
    }
    ans.add(curInterval)
    return ans.toTypedArray()
}