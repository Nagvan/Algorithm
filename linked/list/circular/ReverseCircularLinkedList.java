package linked.list.circular;

import linked.list.entity.Node;
import linked.list.util.LinkedListUtil;

public class ReverseCircularLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        //Circular linked list of odd size
        Node node = new Node(2, new Node(3, new Node(4, new Node(5, head))));
        head.setNext(node);
        LinkedListUtil.printCircularLinkedList(head);
        Node result = reverseCircularLinked(head);
        LinkedListUtil.printCircularLinkedList(result);

        //Circular linked list of even size
        node = new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, head)))));
        head.setNext(node);
        LinkedListUtil.printCircularLinkedList(head);
        result = reverseCircularLinked(head);
        LinkedListUtil.printCircularLinkedList(result);

        //Circular linked list of size 1, i.e. self circular
        head.setNext(head);
        LinkedListUtil.printCircularLinkedList(head);
        result = reverseCircularLinked(head);
        LinkedListUtil.printCircularLinkedList(result);

        //Circular linked list of size 1
        node = new Node(2, head);
        head.setNext(node);
        LinkedListUtil.printCircularLinkedList(head);
        result = reverseCircularLinked(head);
        LinkedListUtil.printCircularLinkedList(result);

        //linked list is null
        LinkedListUtil.printCircularLinkedList(reverseCircularLinked(null));
    }

    /**
     * Function to reverse circular linked list
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * @param head head or start of the circular linked list
     * @return new head of reversed circular linked list
     */
    public static Node reverseCircularLinked(Node head) {
        /*
           if head is null or list is singular return head
         */
        if (head == null || head.getNext() == head) {
            return head;
        }
        Node current = head;
        Node pre = null;
        Node next;
        /*
           reverse the circular linked list till the end of the circular linked list
         */
        while (current.getNext() != head) {
            next = current.getNext();
            current.setNext(pre);
            pre = current;
            current = next;
        }
        //reverse the last node
        current.setNext(pre);
        //set next of head to the last node, which is current at this point
        head.setNext(current);

        //current is the last node of the linked list, just return this node
        return current;
    }
}
