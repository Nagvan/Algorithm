package linked.list.singly;

import linked.list.entity.Node;
import linked.list.util.LinkedListUtil;

public class AddTwoNumbers {
    public static void main(String[] args) {
        //Two numbers of same length
        Node number1 = new Node(8, new Node(4, new Node(2)));
        Node number2 = new Node(9, new Node(7, new Node(5)));
        Node result = addNumbers(number1, number2);
        LinkedListUtil.printLinkedList(result);

        //Number one has more number of digits
        number1 = new Node(9, new Node(4, new Node(2, new Node(9))));
        number2 = new Node(9, new Node(7, new Node(5)));
        result = addNumbers(number1, number2);
        LinkedListUtil.printLinkedList(result);

        //Number two has more number of digits
        number1 = new Node(8, new Node(4, new Node(2)));
        number2 = new Node(9, new Node(7, new Node(5, new Node(6))));
        result = addNumbers(number1, number2);
        LinkedListUtil.printLinkedList(result);

        //Number one is null
        number2 = new Node(9, new Node(7, new Node(5, new Node(6))));
        result = addNumbers(null, number2);
        LinkedListUtil.printLinkedList(result);

        //Number two is null or empty
        number1 = new Node(8, new Node(4, new Node(2)));
        number2 = new Node();
        result = addNumbers(number1, number2);
        LinkedListUtil.printLinkedList(result);

        //Both numbers are null
        LinkedListUtil.printLinkedList(addNumbers(null, null));
    }

    /**
     * Function to add two numbers represented as a linked list
     * Time complexity O(3*(m+n))
     * Space complexity O(1)
     *
     * @param number1 number one to be added
     * @param number2 number two to be added
     * @return list as a sum of two numbers
     */
    private static Node addNumbers(Node number1, Node number2) {
        if (number1 == null) {
            return number2;
        } else if (number2 == null) {
            return number1;
        }
        //reverse the lists
        number1 = LinkedListUtil.reverseSinglyLinkedList(number1);
        number2 = LinkedListUtil.reverseSinglyLinkedList(number2);
        Node result = null;
        int carry = 0;
        Node current = null;
        while (number1 != null || number2 != null) {
            int sum = (number1 == null ? 0 : (Integer) number1.getData()) + (number2 == null ? 0 : (Integer) number2.getData()) + carry;
            carry = sum / 10;
            sum = sum % 10;
            if (result == null) {
                result = new Node(sum);
                current = result;
            } else {
                current.setNext(new Node(sum));
                current = current.getNext();
            }
            if (number1 != null) {
                number1 = number1.getNext();
            }
            if (number2 != null) {
                number2 = number2.getNext();
            }
        }
        //if carry is left, create a node with value as carry and append it to the end.
        if (carry > 0) {
            current.setNext(new Node(carry));
        }
        //reverse the result and return
        return LinkedListUtil.reverseSinglyLinkedList(result);
    }
}
