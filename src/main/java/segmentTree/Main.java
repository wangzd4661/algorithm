package segmentTree;

public class Main {
    public static void main(String[] args) {
        Integer[] nums = {1,2,3,4};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums, (a, b) -> a+b);
        System.out.println(segTree);
        System.out.println(segTree.query(0, 3));
        System.out.println(segTree.query(0, 2));
        segTree.set(3,5);
        System.out.println(segTree.query(0, 3));
    }
}
