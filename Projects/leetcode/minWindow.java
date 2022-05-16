package leetcode

private fun letterMap(t: String): MutableMap<Char, Int> {
    val letterMap: MutableMap<Char, Int> = HashMap()
    for (c in t.toCharArray()) {
        val deficit = letterMap.getOrDefault(c, 0)
        letterMap[c] = deficit + 1
    }
    return letterMap
}

fun minWindow(s: String, t: String): String {
    val letterMap = letterMap(t)
    var curWindow = Window.from(s, letterMap) ?: return ""
    curWindow.refine(s, letterMap)
    var minWindow = curWindow
    for (end in curWindow.end until s.length) {
        val endC = s[end]
        if (!letterMap.containsKey(endC)) continue
        letterMap[endC] = letterMap[endC]!! - 1
        curWindow = Window(curWindow.start, end + 1)
        curWindow.refine(s, letterMap)
        minWindow = if (minWindow.compareTo(curWindow) == -1) minWindow else curWindow
    }
    return s.substring(minWindow.start, minWindow.end)
}

private class Window(var start: Int, var end: Int) : Comparable<Window> {
    override fun compareTo(that: Window): Int {
        val thisLength = end - start
        val thatLength = that.end - that.start
        return if (thisLength > thatLength) 1 else if (thisLength == thatLength) 0 else -1
    }

    fun refine(s: String, letterMap: MutableMap<Char, Int>) {
        while (true) {
            val c = s[start]
            val deficit = letterMap.getOrDefault(c, Int.MAX_VALUE)
            if (deficit == 0) return
            start++
            if (deficit > 0) continue
            letterMap[c] = deficit + 1
        }
    }

    companion object {
        fun from(s: String, letterMap: MutableMap<Char, Int>): Window? {
            var start = -1
            for (i in 0 until s.length) {
                val c = s[i]
                if (!letterMap.containsKey(c) && start == -1) continue
                start = if (start == -1) i else start
                if (!letterMap.containsKey(c)) continue
                letterMap[c] = letterMap[c]!! - 1
                if (letterMap.values.stream().anyMatch { x: Int -> x > 0 }) continue
                return Window(start, i + 1)
            }
            return null
        }
    }
}
