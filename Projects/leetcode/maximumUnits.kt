package leetcode

import java.util.Arrays
import java.util.Comparator

fun maximumUnits(boxTypes: Array<IntArray>, truckSize: Int): Int {
    Arrays.sort(boxTypes, Comparator.comparingInt { boxType: IntArray -> -boxType[1] })
    var deficitSize = truckSize
    var loadedUnit = 0
    for (boxType in boxTypes) {
        if (deficitSize <= 0) break
        val deltaSize = Math.min(boxType[0], deficitSize)
        loadedUnit += deltaSize * boxType[1]
        deficitSize -= deltaSize
    }
    return loadedUnit
}
