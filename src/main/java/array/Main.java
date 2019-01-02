package array;

public class Main {
    public static void main(String[] args) {
        MyArray myArray = new MyArray();
        int[] arr = {1, 2, 3, 23, 54, 6, 3, 23, 54, 6};
        for (int i = 0; i < arr.length; i++) {
            myArray.addLast(arr[i]);
        }
        System.out.println(myArray);
        myArray.add(2, 7);
        System.out.println(myArray);
    }
}
