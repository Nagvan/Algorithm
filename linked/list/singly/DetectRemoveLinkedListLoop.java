package linked.list.singly;

import linked.list.entity.Node;
import linked.list.util.LinkedListUtil;

public class DetectRemoveLinkedListLoop {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.setNext(node3);
        head.setNext(node2);
        //Last node is looping back to node3, Even size loop
        Node node = new Node(4, new Node(5, new Node(6, node3)));
        node3.setNext(node);
        Node result = removeLoop(head);
        LinkedListUtil.printLinkedList(result);
        //Last node is looping back to node3, Odd size loop
        node = new Node(4, new Node(5, new Node(6, new Node(7, node3))));
        node3.setNext(node);
        result = removeLoop(head);
        LinkedListUtil.printLinkedList(result);

        //single loop on self
        node3.setNext(node3);
        result = removeLoop(head);
        LinkedListUtil.printLinkedList(result);

        //No loop
        head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));
        result = removeLoop(head);
        LinkedListUtil.printLinkedList(result);

    }

    /**
     * Function to detect and remove loop in a linked list
     * Time complexity O(2*n)
     * Space complexity O(1)
     *
     * @param head head or start of the linked list
     * @return head or start of the linked list after removal of loop if any
     */
    private static Node removeLoop(Node head) {
        if (head == null) {
            return null;
        }
        //slow will move 1 node at a time
        Node slow = head;
        //fast will move 2 node every time
        Node fast = head;
        //Detect the loop, if slow and fast meets, else no loop
        while (slow != null && fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                break;
            }
        }
        //there is no loop in the linked list
        if (slow == null || fast == null || fast.getNext() == null) {
            System.out.println("Linked list don't have any loop");
            return head;
        }
        //count the nodes in the loop
        int count = 1;
        fast = fast.getNext();
        while (fast != slow) {
            count++;
            fast = fast.getNext();
        }

        //start again and keep fast ahead of slow at distance equal number of nodes in loop
        fast = head;
        while (count > 1) {
            fast = fast.getNext();
            count--;
        }
        /*Move slow and fast 1 at a time, if fast.next = slow, i.e. fast is at the end of the list
          make fast.next null
          Since fast was ahead of number of nodes in loop from slow.
          when fast.next is start that implies fast is at the end.
         */
        slow = head;
        while (fast.getNext() != slow) {
            slow = slow.getNext();
            fast = fast.getNext();
        }
        fast.setNext(null);
        return head;
    }
}
