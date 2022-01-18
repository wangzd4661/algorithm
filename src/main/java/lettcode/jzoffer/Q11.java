package lettcode.jzoffer;

public class Q11 {
    public static void main(String[] args) {
        int[] r=new int[]{3,4,5,1,2};
        int i = new Q11().minArray(r);
        if(i==1){
            System.out.println("success");
        }
    }
    //二分法来找
    public int minArray(int[] numbers) {
        int low=0;
        int high=numbers.length-1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (numbers[pivot] < numbers[high]) {
                high = pivot;
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }
}
