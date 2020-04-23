package lettcode.Q700;

/**
 * 707. 设计链表
 * https://leetcode-cn.com/problems/design-linked-list/
 */
public class Q707 {
    private static class MyLinkedList {
        private class Node {
            public int e;
            public Node next;

            public Node(int e, Node next) {
                this.e = e;
                this.next = next;
            }
            public Node() {
                this(0, null);
            }
        }

        private Node dummyHead;
        private int size;

        /**
         * Initialize your data structure here.
         */
        public MyLinkedList() {
            dummyHead = new Node();
            size = 0;
        }

        /**
         * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
         */
        public int get(int index) {
            if (index < 0 || index >= size) return -1;
            Node cur = dummyHead.next;
            for (int i = 0; i < index; i++) {
                cur = cur.next;
            }
            return cur.e;
        }

        private void add(int index, int e) {
            if (index < 0 || index > size) throw new IllegalArgumentException("illegal input");
            Node pre = dummyHead;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            Node node = new Node(e, pre.next);
            pre.next = node;
            size++;
        }

        /**
         * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
         */
        public void addAtHead(int val) {
            add(0, val);
        }

        /**
         * Append a node of value val to the last element of the linked list.
         */
        public void addAtTail(int val) {
            add(size, val);
        }

        /**
         * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
         */
        public void addAtIndex(int index, int val) {
            if (index >= 0 && index <= size) {
                add(index, val);
            } else if (index < 0) {
                add(0,val);
            }
        }
        /**
         * Delete the index-th node in the linked list, if the index is valid.
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) return;
            Node pre = dummyHead;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            Node delete = pre.next;
            pre.next = delete.next;
            delete.next = null;
            size--;
        }
    }

    public static void main(String[] args) {
        //*["MyLinkedList","addAtHead","deleteAtIndex","addAtHead","addAtHead","addAtHead","addAtHead","addAtHead","addAtTail","get","deleteAtIndex","deleteAtIndex"]
        //[[],[2],[1],[2],[7],[3],[2],[5],[5],[5],[6],[4]]
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.deleteAtIndex(0);
        for (int i = 0; i < 5; i++) {
            linkedList.addAtHead(i);
        }
        linkedList.addAtTail(6);
        linkedList.get(0);
        linkedList.deleteAtIndex(0);
        linkedList.deleteAtIndex(0);
    }

}
