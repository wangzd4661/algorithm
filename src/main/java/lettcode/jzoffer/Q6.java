package lettcode.jzoffer;

import lettcode.tree.ListNode;

import java.util.*;

public class Q6 {
    public static void main(String[] args) {
        int[] ints = new Q6().reversePrint2(new ListNode(new int[]{1, 2, 3, 4, 5}));
        System.out.println(Arrays.toString(ints));
    }
    //思路：遍历保存下来，然后反转
    // O(n),空间：O(n)
    public int[] reversePrint(ListNode head) {
        if(head==null)return new int[0];
        ListNode node=head;
        List<Integer> list=new ArrayList<>();
        while (node!=null){
            list.add(node.val);
            node=node.next;
        }
        int size= list.size();
        int[] res=new int[size];
        for (int i = 0; i < size; i++) {
            res[size-1-i]=list.get(i);
        }
        return res;
    }
    //利用栈。其实没啥区别
    public int[] reversePrint2(ListNode head) {
        if(head==null)return new int[0];
        ListNode node=head;
        Deque<Integer> stack=new ArrayDeque<>();
        while (node!=null){
            stack.push(node.val);
            node=node.next;
        }
        int size= stack.size();
        int[] res=new int[size];
        for (int i = 0; i < size; i++) {
            res[i]=stack.pop();
        }
        return res;
    }
}
