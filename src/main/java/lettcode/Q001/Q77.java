package lettcode.Q001;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 */
public class Q77 {
    public static void main(String[] args) {
        List<List<Integer>> list=new Q77().combine(4,2);
        System.out.printf(""+ Arrays.toString(list.toArray()));
    }

    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n < 1 || k < 1 || n < k) return res;
        findCombine(n,k,1,new LinkedList<>());
        return res;
    }
    private void findCombine(int n, int k, int start, LinkedList<Integer> c){
        if(c.size()==k){
            res.add(new ArrayList<>(c));
            return;
        }
        // i =n - (k - c.size()) + 1
        for (int i = start; i <=n; i++) {
            c.addLast(i);
            findCombine(n,k,i+1,c);
            c.removeLast();
        }
    }
}
