package set;

import array.MyLinkedList;

public class LinkedListSet<E> implements MySet<E> {
    private MyLinkedList list;

    public LinkedListSet() {
        this.list = new MyLinkedList();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
