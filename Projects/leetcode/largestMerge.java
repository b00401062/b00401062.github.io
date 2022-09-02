package leetcode;

class LeetCode {
    public static String largestMerge(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0, j = 0; i < word1.length() || j < word2.length();) {
            if (i == word1.length()) {
                sb.append(word2.substring(j));
                j = word2.length();
            } else if (j == word2.length()) {
                sb.append(word1.substring(i));
                i = word1.length();
            } else if (word1.charAt(i) > word2.charAt(j)) {
                sb.append(word1.charAt(i));
                i++;
            } else if (word1.charAt(i) < word2.charAt(j)) {
                sb.append(word2.charAt(j));
                j++;
            } else {
                int diff = word1.substring(i).compareTo(word2.substring(j));
                if (diff >= 0) {
                    sb.append(word1.charAt(i));
                    i++;
                } else {
                    sb.append(word2.charAt(j));
                    j++;
                }
            }
        }
        return sb.toString();
    }
}
