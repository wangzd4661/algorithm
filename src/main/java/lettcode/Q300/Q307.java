package lettcode.Q300;

import segmentTree.SegmentTree;

/**
 * 307. 区域和检索 - 数组可修改
 * https://leetcode-cn.com/problems/range-sum-query-mutable/
 */
public class Q307 {
    public static void main(String[] args) {

    }

    private class NumArray {
        private SegmentTree<Integer> segTree;

        public NumArray(int[] nums) {
            if (nums.length != 0) {
                Integer[] data = new Integer[nums.length];
                for (int i = 0; i < nums.length; i++)
                    data[i] = nums[i];
                segTree = new SegmentTree<>(data, (a, b) -> a + b);
            }
        }

        public void update(int i, int val) {
            if (segTree == null)
                throw new IllegalArgumentException("Error");
            segTree.set(i, val);
        }

        public int sumRange(int i, int j) {
            if (segTree == null)
                throw new IllegalArgumentException("Error");
            return segTree.query(i, j);
        }
    }
}

