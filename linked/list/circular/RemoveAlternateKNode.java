package linked.list.circular;

import linked.list.entity.Node;
import linked.list.util.LinkedListUtil;

public class RemoveAlternateKNode {
    public static void main(String[] args) {
        Node head = new Node(1);
        //Circular linked list of odd size
        Node node = new Node(2, new Node(3, new Node(4, new Node(5, head))));
        head.setNext(node);
        LinkedListUtil.printCircularLinkedList(head);
        int k = 1;
        Node result = removeAlternateKNode(head, k);
        LinkedListUtil.printCircularLinkedList(result);

        node = new Node(2, new Node(3, new Node(4, new Node(5, new Node(6, new Node(7, new Node(8, new Node(9, head))))))));
        head.setNext(node);
        LinkedListUtil.printCircularLinkedList(head);
        k = 4;
        result = removeAlternateKNode(head, k);
        LinkedListUtil.printCircularLinkedList(result);
    }

    /**
     * Function to remove alternate kth node
     * Time complexity O((k-1)*(n-1)) -> Every inner iteration takes (k-1), this has happen forever, but size of ring is decreasing by 1 everytime, so by n-1 outer iteration, we will have 1 node left
     * Space complexity O(1)
     *
     * @param head head or start of the linked list
     * @param k    number at which the element should be deleted. (Note there can be variation of this problem:
     *             like delete node after kth or delete next and start from the same node.
     *             We can make small change and make it work for any given condition, but the base logic will remain same)
     *             The one solved below is delete kth node and start from k+1 node.
     * @return single left node after deletion of all kth node
     */
    private static Node removeAlternateKNode(Node head, int k) {
        if (head == null || head.getNext() == head) {
            return head;
        }
        Node current = head;
        while (current.getNext() != current) {
            int count = k - 1;
            while (count > 0) {
                current = current.getNext();
                count--;
            }
            current.setNext(current.getNext().getNext());
            current = current.getNext();
        }

        return current;
    }
}
