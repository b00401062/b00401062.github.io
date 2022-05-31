package leetcode;

public static String interpret(String command) {
    return command.replace("()", "o").replace("(al)", "al");
}
