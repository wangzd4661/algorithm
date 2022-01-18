package lettcode.jzoffer;

public class Q4 {
    public static void main(String[] args) {
        int[][] r = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10,13,14,17, 24},
                {18,21,23,26, 30}};
        Q4 q4 = new Q4();
        boolean numberIn2DArray1 = q4.findNumberIn2DArray(r, 5);
        boolean numberIn2DArray2 = q4.findNumberIn2DArray(r, 20);
        System.out.println(numberIn2DArray1 + "," + numberIn2DArray2);
    }

    //思路：二分法，对角线，左上角元素小于右下角元素
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        return false;
    }
}
