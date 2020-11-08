package linked.list.util;

import linked.list.entity.Node;

public class LinkedListUtil {
    private LinkedListUtil() {
    }

    /**
     * Function to print the list elements
     * Time complexity O(n)
     * Space complexity O(1)
     * @param head head or starting point of the linked list
     */
    public static void printLinkedList(Node head) {
        if(head == null){
            System.out.println("List is Empty");
            return;
        }
        Node current = head;
        System.out.println("Printing List");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Function to find the total size of the list
     * Time complexity O(n)
     * Space complexity O(1)
     * @param head head or start of the list
     * @return total size of the list
     */
    public static int size(Node head) {
        if (head == null) {
            return 0;
        }
        Node current = head;
        int size = 0;
        while (current != null) {
            size++;
            current = current.getNext();
        }
        return size;
    }

    /**
     * Function to reverse the singly linked list
     * Time complexity O(n)
     * Space complexity O(1)
     * @param head head or start of the list
     * @return reversed linked list (head)
     */
    public static Node reverseSinglyLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        Node pre = null;
        Node current = head;
        Node next;
        while (current != null) {
            next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }
        return pre;
    }
}
