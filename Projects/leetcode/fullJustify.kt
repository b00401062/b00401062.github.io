package leetcode

import java.lang.StringBuilder
import java.util.ArrayList

fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
    val res: MutableList<String> = ArrayList()
    if (words.size > 0 && maxWidth > 0) {
        var i = 0
        while (i < words.size) {
            var lineLength = words[i].length
            var j = i + 1
            while (j < words.size) {
                lineLength += if (lineLength + words[j].length + (j - i) <= maxWidth) {
                    words[j].length
                } else {
                    break
                }
                j++
            }
            val numOfWords = j - i
            val diff = maxWidth - lineLength
            if (numOfWords == 1 || j >= words.size) {
                res.add(leftJustified(i, j, words, diff))
            } else {
                res.add(middleJustified(i, j, words, diff))
            }
            i = j
        }
    }
    return res
}

fun leftJustified(i: Int, j: Int, words: Array<String>, diff: Int): String {
    var i = i
    var spacesOnRight = diff - (j - i - 1)
    var spaceBetween = j - i - 1
    val sb = StringBuilder()
    while (i < j) {
        sb.append(words[i])
        if (spaceBetween > 0) {
            sb.append(" ")
            spaceBetween--
        }
        i++
    }
    while (spacesOnRight > 0) {
        sb.append(" ")
        spacesOnRight--
    }
    return sb.toString()
}

fun middleJustified(i: Int, j: Int, words: Array<String>, diff: Int): String {
    val spaceSlots = j - i - 1
    val spaceBetween = diff / spaceSlots
    var leftSpaces = diff % spaceSlots
    val sb = StringBuilder()
    var k = i
    while (k < j) {
        var spaces = spaceBetween
        sb.append(words[k])
        while (k < j - 1 && spaces > 0) {
            sb.append(" ")
            spaces--
        }
        if (leftSpaces > 0 && k < j - 1) {
            sb.append(" ")
            leftSpaces--
        }
        k++
    }
    return sb.toString()
}
