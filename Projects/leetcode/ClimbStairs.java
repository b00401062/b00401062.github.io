package leetcode;

import java.util.Iterator;
import java.util.stream.StreamSupport;

class ClimbStairs {
    private static class Fibonacci implements Iterable<Integer> {
        @Override
        public Iterator<Integer> iterator() {
            return new Iterator<Integer>() {
                int[] cache = new int[] { 1, 1 };

                @Override
                public boolean hasNext() {
                    return true;
                }

                @Override
                public Integer next() {
                    int value = cache[0];
                    cache[0] = cache[1];
                    cache[1] = value + cache[0];
                    return value;
                }
            };
        }
    }

    public static int climbStairs(int n) {
        return StreamSupport.stream(new Fibonacci().spliterator(), false).skip(n).findFirst().get();
    }
}
