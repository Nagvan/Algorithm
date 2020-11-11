package linked.list.doubly;

import linked.list.entity.DoublyNode;
import linked.list.util.LinkedListUtil;

public class ReverseDoublyLinkedList {
    public static void main(String[] args) {
        DoublyNode head = new DoublyNode(1);
        DoublyNode node1 = new DoublyNode(2);
        DoublyNode node2 = new DoublyNode(3);
        DoublyNode node3 = new DoublyNode(4);
        DoublyNode node4 = new DoublyNode(5);

        head.setNext(node1);
        node1.setNext(node2);
        node1.setPrev(head);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setNext(node4);
        node3.setPrev(node2);
        node4.setPrev(node3);
        //Doubly linked list of odd size
        LinkedListUtil.printDoublyLinkedList(head);
        DoublyNode result = LinkedListUtil.reverseDoublyLinkedList(head);
        LinkedListUtil.printDoublyLinkedList(result);

        head.setNext(node1);
        node1.setNext(node2);
        node1.setPrev(head);
        node2.setNext(node3);
        node2.setPrev(node1);
        node3.setNext(node4);
        node3.setPrev(node2);
        node4.setPrev(node3);
        DoublyNode node5 = new DoublyNode(6);
        node4.setNext(node5);
        node5.setPrev(node4);

        //Doubly linked list of even size
        LinkedListUtil.printDoublyLinkedList(head);
        result = LinkedListUtil.reverseDoublyLinkedList(head);
        LinkedListUtil.printDoublyLinkedList(result);

        head = new DoublyNode('A');
        //Doubly linked list of even size
        LinkedListUtil.printDoublyLinkedList(head);
        result = LinkedListUtil.reverseDoublyLinkedList(head);
        LinkedListUtil.printDoublyLinkedList(result);

        //Doubly linked list is null or empty
        LinkedListUtil.printDoublyLinkedList(LinkedListUtil.reverseDoublyLinkedList(null));
    }


}
