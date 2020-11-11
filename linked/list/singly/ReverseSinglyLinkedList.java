package linked.list.singly;

import linked.list.entity.Node;
import linked.list.util.LinkedListUtil;

public class ReverseSinglyLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7)))))));
        LinkedListUtil.printLinkedList(head);
        head = LinkedListUtil.reverseSinglyLinkedList(head);
        LinkedListUtil.printLinkedList(head);

        head = new Node("A");
        LinkedListUtil.printLinkedList(head);
        head = LinkedListUtil.reverseSinglyLinkedList(head);
        LinkedListUtil.printLinkedList(head);

        head = new Node(2.8, new Node(9.1));
        LinkedListUtil.printLinkedList(head);
        head = LinkedListUtil.reverseSinglyLinkedList(head);
        LinkedListUtil.printLinkedList(head);
    }
}
