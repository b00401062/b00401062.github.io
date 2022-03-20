package leetcode;

import java.util.Arrays;

class GetMaximumGenerated {
    public static int getMaximumGenerated(int n) {
        if (n == 0) return 0;
        final int[] nums = new int[n + 1];
        nums[0] = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            nums[i] = (
                i % 2 == 0 ? nums[i / 2] :
                nums[i / 2] + nums[i / 2 + 1]
            );
        }
        return Arrays.stream(nums).max().getAsInt();
    }
}
