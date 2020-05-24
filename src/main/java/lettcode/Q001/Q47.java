package lettcode.Q001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *47
 */
public class Q47 {
    public static void main(String[] args) {
        List<List<Integer>> list=new Q47().permuteUnique(new int[]{1,1,2});
        System.out.printf(""+ Arrays.toString(list.toArray()));
    }

    private List<List<Integer>> res;
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null || nums.length == 0) return res;
        res=new ArrayList<>();
        used=new boolean[nums.length];
        Arrays.sort(nums);
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
                if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
                used[i]=true;
                c.addLast(nums[i]);
                findPermute(nums,c);
                c.removeLast();
                used[i]=false;
            }
        }
    }
}
