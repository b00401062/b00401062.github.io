package leetcode;

import java.util.*;

class RemoveDuplicateLetters {
    public static String removeDuplicateLetters(String s) {
        boolean[] seen = new boolean[26];
        int[] count = new int[26];
        for (char c : s.toCharArray()){
            count[c - 'a']++;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            count[c - 'a']--;
            if (seen[c - 'a']){
                continue;
            }
            while(!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0){
                seen[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            seen[c - 'a'] = true;
        }
        StringBuilder subsequence = new StringBuilder();
        while(!stack.isEmpty()){
            subsequence.append(stack.pop());
        }
        return subsequence.reverse().toString();
    }
}
