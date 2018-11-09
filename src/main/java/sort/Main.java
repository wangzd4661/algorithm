package sort;

public class Main {
    public static int[] a = {1, 7, 8, 2, 9, 5, 4,1};

    public static void main(String[] args) {
        Sort sort = new SelectionSort();
        sort.sort(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
