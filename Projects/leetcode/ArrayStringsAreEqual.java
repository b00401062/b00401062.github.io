package leetcode;

import java.util.Iterator;

class ArrayStringsAreEqual {
    private static class CharStream implements Iterable<Character> {
        private final String[] words;

        CharStream(String[] words) {
            this.words = words;
        }

        @Override
        public Iterator<Character> iterator() {
            return new Iterator<>() {
                private int wordIdx;
                private int charIdx;

                @Override
                public boolean hasNext() {
                    return (
                        wordIdx < words.length &&
                        charIdx < words[wordIdx].length()
                    );
                }

                @Override
                public Character next() {
                    char c = words[wordIdx].charAt(charIdx);
                    charIdx++;
                    if (charIdx == words[wordIdx].length()) {
                        wordIdx++;
                        charIdx = 0;
                    }
                    return c;
                }
            };
        }
    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        Iterator<Character> iter1 = new CharStream(word1).iterator();
        Iterator<Character> iter2 = new CharStream(word2).iterator();
        while (iter1.hasNext() && iter2.hasNext()) {
            if (iter1.next() != iter2.next()) return false;
        }
        return !iter1.hasNext() && !iter2.hasNext();
    }
}
