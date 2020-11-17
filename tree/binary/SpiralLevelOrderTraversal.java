package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

import java.util.Stack;

public class SpiralLevelOrderTraversal {
    public static void main(String[] args) {
        /**
         *                  9
         *              /      \
         *            2         6
         *          /   \      /
         *        5       3   4
         *      /       /  \
         *    1       8      7
         */
        Node root = TreeUtil.binaryTree1();
        spiralLevelOrderTraversal(root);

        System.out.println();
        /**
         *                  7
         *              /      \
         *            3         9
         *          /   \      /  \
         *        2      5   8     10
         *             /  \
         *           4      6
         */
        root = TreeUtil.binarySearchTree1();
        spiralLevelOrderTraversal(root);

    }

    private static void spiralLevelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack1 = new Stack();
        Stack<Node> stack2 = new Stack();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                Node current = stack1.pop();
                System.out.print(current.getData() + " ");
                if (current.getLeft() != null) {
                    stack2.push(current.getLeft());
                }
                if (current.getRight() != null) {
                    stack2.push(current.getRight());
                }
            }
            while (!stack2.isEmpty()) {
                Node current = stack2.pop();
                System.out.print(current.getData() + " ");
                if (current.getRight() != null) {
                    stack1.push(current.getRight());
                }
                if (current.getLeft() != null) {
                    stack1.push(current.getLeft());
                }
            }
        }
    }
}
