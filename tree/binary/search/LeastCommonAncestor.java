package tree.binary.search;

import tree.entity.Node;
import tree.util.TreeUtil;

public class LeastCommonAncestor {
    public static void main(String[] args) {
        /*
         *                  7
         *              /      \
         *            3         9
         *          /   \      /  \
         *        2      5   8     10
         *             /  \
         *           4      6
         */
        Node root = TreeUtil.binarySearchTree1();

        int node1 = 8, node2 = 5;
        Node ancestor = leastCommonAncestor(root, node1, node2);
        System.out.println("least common ancestor of " + node1 + " and " + node2 + " is: " + (ancestor == null ? "NULL" : ancestor.getData()));

        node1 = 6;
        node2 = 2;
        ancestor = leastCommonAncestor(root, node1, node2);
        System.out.println("least common ancestor of " + node1 + " and " + node2 + " is: " + (ancestor == null ? "NULL" : ancestor.getData()));

        node1 = 6;
        node2 = 11;
        //Node 11 is not present in the binary search tree
        ancestor = leastCommonAncestor(root, node1, node2);
        System.out.println("least common ancestor of " + node1 + " and " + node2 + " is: " + (ancestor == null ? "NULL" : ancestor.getData()));

        node1 = 9;
        node2 = 10;
        //Node 9 is common to both 9 and 10
        ancestor = leastCommonAncestor(root, node1, node2);
        System.out.println("least common ancestor of " + node1 + " and " + node2 + " is: " + (ancestor == null ? "NULL" : ancestor.getData()));
    }

    /**
     * Function to find the least common ancestor of node1 and node2 of Binary Search Tree
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * @param root  root of Binary Search Tree
     * @param node1 node 1
     * @param node2 node 2
     * @return least common ancestor of node1 and node2 if both are present in the Binary Search Tree
     */
    private static Node leastCommonAncestor(Node root, int node1, int node2) {
        if (root == null) {
            return null;
        }
        //Check if the nodes are available in the Binary Search Tree
        if (TreeUtil.isNodeAvailable(root, node1) && TreeUtil.isNodeAvailable(root, node2)) {
            return leastCommonAncestorUtil(root, node1, node2);
        } else {
            //return null if any of the node is missing from the Binary Search Tree
            return null;
        }
    }

    /**
     * Utility to find the least common ancestor of node1 and node2 of Binary Search Tree
     * Call this method only if both the nodes are present in the tree
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * @param root  root of Binary Search Tree
     * @param node1 node 1
     * @param node2 node 2
     * @return least common ancestor of node1 and node2 if both are present in the Binary Search Tree
     */
    private static Node leastCommonAncestorUtil(Node root, int node1, int node2) {
        if (root == null) {
            return null;
        }
        //If root is either of the node, return root
        if (root.getData().equals(node1) || root.getData().equals(node2)) {
            return root;
        }
        //If root is greater than both the node, search in left subtree
        if ((Integer) root.getData() > node1 && (Integer) root.getData() > node2) {
            return leastCommonAncestor(root.getLeft(), node1, node2);
        }
        //If root is smaller than both the node, search in right subtree
        else if ((Integer) root.getData() < node1 && (Integer) root.getData() < node2) {
            return leastCommonAncestor(root.getRight(), node1, node2);
        }
        //One node is on the left subtree and other on the right subtree, return the root
        else {
            return root;
        }
    }
}
