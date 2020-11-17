package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class Cousins {
    public static void main(String[] args) {

        /*
         *                  9
         *              /      \
         *            2         6
         *          /   \      /
         *        5       3   4
         *      /       /  \
         *    1       8      7
         */
        Node root = TreeUtil.binaryTree1();
        printCousins(root, 5);

        printCousins(root, 7);
    }

    /**
     * Print all the cousins of a binary tree
     * Time complexity O(n)
     * Space complexity O(n)
     *
     * @param root root of the binary tree
     * @param node node who's cousins we have to find
     */
    private static void printCousins(Node root, int node) {
        if (root == null || root.getData().equals(node)) {
            return;
        }
        Queue<Node> queue = new LinkedList();
        boolean found = false;
        Node sibling = null;
        queue.add(root);
        //Traverse the tree level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                Node current = queue.poll();
                if (current.getLeft() != null) {
                    queue.add(current.getLeft());
                    //if current root left is the node, next level will have all the cousins and sibling, sibling is on right of root
                    if (current.getLeft().getData().equals(node)) {
                        found = true;
                        sibling = current.getRight();
                    }
                }
                if (current.getRight() != null) {
                    queue.add(current.getRight());
                    //if current root right is the node, next level will have all the cousins and sibling, sibling is on left of root
                    if (current.getRight().getData().equals(node)) {
                        found = true;
                        sibling = current.getLeft();
                    }
                }
                size--;
            }
            //If node was found, all the items in this level has siblings or cousins
            if (found) {
                while (!queue.isEmpty()) {
                    Node current = queue.poll();
                    //print all the items, but not the node and its sibling
                    if (current != sibling && !current.getData().equals(node)) {
                        System.out.println(current.getData());
                    }
                }
            }
        }
    }
}
