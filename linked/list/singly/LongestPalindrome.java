package linked.list.singly;

import linked.list.entity.Node;

public class LongestPalindrome {
    public static void main(String[] args) {
        //Linked list of odd length palindrome 7->1->5->1->7
        Node head = new Node(7, new Node(1, new Node(5, new Node(1, new Node(7, new Node(8, new Node(3)))))));
        int longestPalindromeLength = getLongestPalindromeLength(head);
        System.out.println(longestPalindromeLength);

        //Linked list of even length palindrome C->D->D->C
        head = new Node('A', new Node('B', new Node('C', new Node('D', new Node('D', new Node('C'))))));
        longestPalindromeLength = getLongestPalindromeLength(head);
        System.out.println(longestPalindromeLength);

        //No palindrome present, so every node will act as palindrome i.e. every literal is palindrome by itself
        head = new Node('A', new Node('B', new Node('C', new Node('D', new Node('E', new Node('C'))))));
        longestPalindromeLength = getLongestPalindromeLength(head);
        System.out.println(longestPalindromeLength);

        //list is null
        System.out.println(getLongestPalindromeLength(null));
    }

    /**
     * Function to find the length of the longest palindrome present in a list if any present
     * @param head head or start of the linked list
     * @return length of the longest palindrome
     */
    private static int getLongestPalindromeLength(Node head) {
        if (head == null) {
            return 0;
        }

        int maxLength = 0;
        Node current = head, pre = null;
        /*
           reverse list one by one starting from head
           check for both even and odd length palindrome with that current as axis
         */
        while (current != null) {
            Node next = current.getNext();
            current.setNext(pre);
            //Find max length of odd length, with current as axis
            maxLength = Math.max(maxLength, 2 * getCommonCount(pre, next) + 1);

            //Find max length of even length
            maxLength = Math.max(maxLength, 2 * getCommonCount(current, next));

            pre = current;
            current = next;
        }
        return maxLength;
    }

    /**
     * Function to find common node from the start of the list
     * Time complexity O(Min(m,n))
     * Space complexity O(1)
     * @param head1 head or start of the list one
     * @param head2 head or start of the list two
     * @return count of common value node of two list starting from start
     */
    private static int getCommonCount(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return 0;
        }
        int count = 0;
        while (head1 != null && head2 != null && head1.getData().equals(head2.getData())) {
            head1 = head1.getNext();
            head2 = head2.getNext();
            count++;
        }
        return count;
    }
}
