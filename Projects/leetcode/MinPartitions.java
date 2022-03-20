package leetcode;

public class MinPartitions {
    public static int minPartitions(String n) {
        return n.chars().map(x -> x - '0').max().getAsInt();
    }
}
