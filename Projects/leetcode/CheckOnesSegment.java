package leetcode;

class CheckOnesSegment {
    public static boolean checkOnesSegment(String s) {
        return s.split("0+").length == 1;
    }
}
