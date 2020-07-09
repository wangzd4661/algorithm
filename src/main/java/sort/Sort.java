package sort;

public abstract class Sort {
    public abstract void sort(Integer[] arr);

    void exch(Integer[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
