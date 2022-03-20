package leetcode;

class NumDistinct {
    public int numDistinct(String s, String t) {
        int[] table = new int[t.length() + 1];
        table[0] = 1;
        for (char s_i : s.toCharArray()) {
            for (int j = t.length() - 1; j >= 0; j--) {
                char t_j = t.charAt(j);
                if (s_i == t_j) table[j + 1] += table[j];
            }
        }
        return table[t.length()];
    }
}
