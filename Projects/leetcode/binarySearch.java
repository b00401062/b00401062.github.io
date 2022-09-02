package leetcode;

class LeetCode {
    public int binarySearch(int[] v, int k) {
        int lt = 0;
        int rt = v.length;
        int md = (lt + rt) / 2;
        while (lt < rt) {
            if (k < v[md]) rt = md;
            else if (k == v[md]) return md;
            else lt = md + 1;
            md = (lt + rt) / 2;
        }
        return -1 - md;
    }
}
