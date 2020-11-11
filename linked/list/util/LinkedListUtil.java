package linked.list.util;

import linked.list.entity.DoublyNode;
import linked.list.entity.Node;

public class LinkedListUtil {
    private LinkedListUtil() {
    }

    /**
     * Function to print the list elements
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * @param head head or starting point of the linked list
     */
    public static void printLinkedList(Node head) {
        if (head == null) {
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
     * Function to print the doubly linked list elements
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * @param head head or starting point of the doubly linked list
     */
    public static void printDoublyLinkedList(DoublyNode head) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        DoublyNode current = head;
        System.out.println("Printing Doubly Linked List");
        while (current != null) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Function to print the circular linked list elements
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * @param head head or starting point of the linked list
     */
    public static void printCircularLinkedList(Node head) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }
        System.out.println("Printing List");
        System.out.print(head.getData() + " ");
        Node current = head.getNext();
        while (current != head) {
            System.out.print(current.getData() + " ");
            current = current.getNext();
        }
        System.out.println();
    }

    /**
     * Function to find the total size of the list
     * Time complexity O(n)
     * Space complexity O(1)
     *
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
     *
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

    /**
     * Function to reverse doubly linked list
     * Time complexity O(n)
     * Space complexity O(1)
     * @param head head or start of the linked list
     * @return reversed doubly linked list head
     */
    public static DoublyNode reverseDoublyLinkedList(DoublyNode head){
        if(head == null){
            return null;
        }
        DoublyNode current = head;
        DoublyNode pre = null;
        DoublyNode next;
        while(current != null){
            next = current.getNext();
            current.setNext(pre);
            current.setPrev(next);
            pre = current;
            current = next;
        }
        return pre;
    }

    /**
     * Merge sort of the singly linked list
     * Time complexity O(nlog(n))
     * Space complexity O(1)
     *
     * @param head head or start of the linked list
     * @return head or start of the sorted linked list
     */
    public static Node mergeSort(Node head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        //split the linked list from middle
        Node middle = getMiddle(head);
        Node right = middle.getNext();
        middle.setNext(null);

        //recursively merge left and right part of the split linked list
        Node head1 = mergeSort(head);
        Node head2 = mergeSort(right);

        /*at this point left and right part of the list will be sorted
          Just merge those sorted left and right part of the linked list.

          Initially the whole list will be broken to two small small parts,
          then those two pieces will be combined to single sorted list.
          And recursively the entire such small small list will be sorted.
         */
        return sortedMerge(head1, head2);
    }

    /**
     * Function to sort two sorted linked list
     * Time complexity O(m+n)
     * Space complexity O(1)
     *
     * @param head1 head or start of list one
     * @param head2 head or start of list two
     * @return head or start of sorted list of two sorted linked list
     */
    public static Node sortedMerge(Node head1, Node head2) {
        if (head1 == null) {
            return head2;
        } else if (head2 == null) {
            return head1;
        }
        Node result = new Node();
        /*
           Pick the smallest node
           add it to the result
           recursively add other nodes in the result
         */
        if ((Integer) head1.getData() <= (Integer) head2.getData()) {
            result.setData(head1.getData());
            result.setNext(sortedMerge(head1.getNext(), head2));
        } else {
            result.setData(head2.getData());
            result.setNext(sortedMerge(head1, head2.getNext()));
        }
        return result;
    }

    /**
     * Function to get the middle of the linked list
     * Time complexity O(n/2)
     * Space complexity O(1)
     *
     * @param head head or start of the linked list
     * @return middle node of the linked list
     */
    public static Node getMiddle(Node head) {
        if (head == null) {
            return null;
        }
        /* slow moves one node at a time
           fast moves two nodes at a time
           when fast reaches end, slow will be at the mid of the list
         */
        Node slow = head;
        Node fast = head.getNext();
        while (slow != null && fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        // at this point slow is at the mid of the linked list, just return the node
        return slow;
    }
}
