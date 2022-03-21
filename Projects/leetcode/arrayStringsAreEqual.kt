package leetcode

fun arrayStringsAreEqual(word1: Array<String>, word2: Array<String>): Boolean {
    val iter1: Iterator<Char?> = CharStream(word1).iterator()
    val iter2: Iterator<Char?> = CharStream(word2).iterator()
    while (iter1.hasNext() && iter2.hasNext()) {
        if (iter1.next() !== iter2.next()) return false
    }
    return !iter1.hasNext() && !iter2.hasNext()
}

private class CharStream(private val words: Array<String>) : Iterable<Char?> {
    override fun iterator(): Iterator<Char?> {
        return object : Iterator<Char?> {
            private var wordIdx = 0
            private var charIdx = 0
            override fun hasNext(): Boolean {
                return wordIdx < words.size &&
                        charIdx < words[wordIdx].length
            }

            override fun next(): Char {
                val c = words[wordIdx][charIdx]
                charIdx++
                if (charIdx == words[wordIdx].length) {
                    wordIdx++
                    charIdx = 0
                }
                return c
            }
        }
    }
}
