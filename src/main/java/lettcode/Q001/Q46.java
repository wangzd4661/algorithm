package lettcode.Q001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Q46 {
    public static void main(String[] args) {
        List<List<Integer>> list=new Q46().permute(new int[]{1,2,3});
        System.out.printf(""+ Arrays.toString(list.toArray()));
    }

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        res=new ArrayList<>();
        used=new boolean[nums.length];
        findPermute(nums, new LinkedList<>());
        return res;
    }

    /**
     * 思想：回溯法
     *
     * @param nums
     * @param c
     */
    private void findPermute(int[] nums, LinkedList<Integer> c) {
        if (c.size() == nums.length) {
            res.add(new ArrayList<>(c));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                used[i]=true;
                c.addLast(nums[i]);
                findPermute(nums,c);
                c.removeLast();
                used[i]=false;
            }
        }
    }

}
