package linked.list.singly;

import linked.list.entity.Node;
import linked.list.util.LinkedListUtil;

public class MergeSort {
    public static void main(String[] args) {
        //List of even size
        Node head = new Node(7, new Node(3, new Node(1, new Node(8, new Node(9, new Node(2, new Node(6, new Node(4))))))));
        LinkedListUtil.printLinkedList(head);
        head = LinkedListUtil.mergeSort(head);
        LinkedListUtil.printLinkedList(head);

        ////List of odd size
        head = new Node(7, new Node(3, new Node(1, new Node(8, new Node(9, new Node(2, new Node(6, new Node(4, new Node(5)))))))));
        LinkedListUtil.printLinkedList(head);
        head = LinkedListUtil.mergeSort(head);
        LinkedListUtil.printLinkedList(head);

        //list is null
        LinkedListUtil.printLinkedList(LinkedListUtil.mergeSort(null));
    }
}
