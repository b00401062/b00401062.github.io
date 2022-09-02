package leetcode;

class LeetCode {
    public static String interpret(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }
}
