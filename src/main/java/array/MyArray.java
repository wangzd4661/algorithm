package array;

public class MyArray {
    private int[] data;
    private int size;

    public MyArray() {
        this(10);
    }

    public MyArray(int capacity) {
        data = new int[capacity];
    }

    public void addLast(int e) {
        add(size, e);
    }

    public void add(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index");
        }
        if (size == data.length) {
            resize(2 * size);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int s) {
        int[] newData = new int[s];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public int get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index");
        }
        return data[index];
    }

    public void set(int index, int e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index");
        }
        data[index] = e;
    }

    public int remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("index");
        }
        int re = data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        if (size == data.length / 4&&data.length/2!=0) {
            resize(size / 2);
        }
        return re;
    }

    public void removeElement(int e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public boolean contain(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }


    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("capacity:" + getCapacity() + "," + "size:" + size + ",");
        sb.append("array:");
        for (int i = 0; i < size; i++) {
            sb.append(data[i] + ",");
        }
        return sb.toString();
    }
}
