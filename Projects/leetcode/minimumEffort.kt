package leetcode

import java.util.Arrays
import java.util.Comparator
import java.util.function.ToIntFunction

internal object MinimumEffort {
    fun minimumEffort(tasks: Array<IntArray>): Int {
        Arrays.sort(tasks, Comparator.comparingInt { task: IntArray -> task[1] - task[0] })
        var minimumEffort = 0
        for (task in tasks) {
            minimumEffort = Math.max(minimumEffort + task[0], task[1])
        }
        return minimumEffort
    }
}