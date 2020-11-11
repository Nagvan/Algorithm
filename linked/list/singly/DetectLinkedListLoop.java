package linked.list.singly;

import linked.list.entity.Node;

public class DetectLinkedListLoop {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.setNext(node3);
        head.setNext(node2);
        //Last node is looping back to node3, Even size loop
        Node node = new Node(4, new Node(5, new Node(6, node3)));
        node3.setNext(node);
        if (isLoopPresent(head)) {
            System.out.println("Loop is detected in the Linked List");
        } else {
            System.out.println("Linked list don't have any loop");
        }

        //Last node is looping back to node3, Odd size loop
        node = new Node(4, new Node(5, new Node(6, new Node(7, node3))));
        node3.setNext(node);
        if (isLoopPresent(head)) {
            System.out.println("Loop is detected in the Linked List");
        } else {
            System.out.println("Linked list don't have any loop");
        }

        //Odd length list with no loop
        head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7)))))));
        if (isLoopPresent(head)) {
            System.out.println("Loop is detected in the Linked List");
        } else {
            System.out.println("Linked list don't have any loop");
        }

        //Even length list with no loop
        head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5, new Node(6))))));
        if (isLoopPresent(head)) {
            System.out.println("Loop is detected in the Linked List");
        } else {
            System.out.println("Linked list don't have any loop");
        }
    }

    /**
     * Function to detect if the linked list has any loop
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * @param head head or start of the linked list
     * @return true if loop is present else false
     */
    private static boolean isLoopPresent(Node head) {
        if (head == null) {
            return false;
        }
        //slow will move 1 node at a time
        Node slow = head;
        //fast will move 2 node every time
        Node fast = head;
        while (slow != null && fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
