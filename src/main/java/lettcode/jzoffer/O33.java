package lettcode.jzoffer;

import array.Stack;

import java.util.LinkedList;

public class O33 {
    public boolean verifyPostorder(int[] postorder) {
        int root=Integer.MAX_VALUE;
        LinkedList<Integer> stack= new LinkedList<>();
        for (int i = postorder.length-1; i >=0; i--) {
            if(postorder[i]>root)return false;
            while (!stack.isEmpty()&&stack.peek()>postorder[i]){
                root=stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }
}
