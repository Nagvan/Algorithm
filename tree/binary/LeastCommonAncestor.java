package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

public class LeastCommonAncestor {
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
        int node1 = 5, node2 = 8;
        //First check if both the nodes are present or not
        Node ancestor = leastCommonAncestor(root, node1, node2);
        System.out.println("least common ancestor of " + node1 + " and " + node2 + " is: " + (ancestor == null ? "NULL" : ancestor.getData()));

        node1 = 2;
        node2 = 3;
        //First check if both the nodes are present or not, here 2 is parent of 3
        ancestor = leastCommonAncestor(root, node1, node2);
        System.out.println("least common ancestor of " + node1 + " and " + node2 + " is: " + (ancestor == null ? "NULL" : ancestor.getData()));

        node1 = 3;
        node2 = 10;
        //First check if both the nodes are present or not, here 10 is not present in the tree
        ancestor = leastCommonAncestor(root, node1, node2);
        System.out.println("least common ancestor of " + node1 + " and " + node2 + " is: " + (ancestor == null ? "NULL" : ancestor.getData()));
    }

    /**
     * Function to find the least common ancestor of node1 and node2 of Binary Tree
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * @param root  root of Binary Tree
     * @param node1 node 1
     * @param node2 node 2
     * @return least common ancestor of node1 and node2 if both are present in the Binary Tree
     */
    private static Node leastCommonAncestor(Node root, int node1, int node2) {
        if (root == null) {
            return null;
        }
        //Check if the nodes are available in the Binary Tree
        if (TreeUtil.isNodeAvailable(root, node1) && TreeUtil.isNodeAvailable(root, node2)) {
            return leastCommonAncestorUtil(root, node1, node2);
        } else {
            //return null if any of the node is missing from the Binary Tree
            return null;
        }
    }

    /**
     * Function to find the least common ancestor of two nodes
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * @param root  root of the Binary Tree
     * @param node1 node 1
     * @param node2 node 2
     * @return least common ancestor of two nodes, note this will return if any of the node is found,
     * so check those nodes if present in the tree or not, before calling this method
     */
    private static Node leastCommonAncestorUtil(Node root, int node1, int node2) {
        if (root == null) {
            return null;
        }
        //If root is either node1 or node2, return root
        if (root.getData().equals(node1) || root.getData().equals(node2)) {
            return root;
        }
        Node leftCommon = leastCommonAncestor(root.getLeft(), node1, node2);
        Node rightCommon = leastCommonAncestor(root.getRight(), node1, node2);
        //If one node is found in left subtree and other on right subtree, root is the common ancestor. Return root.
        if (leftCommon != null && rightCommon != null) {
            return root;
        }

        return (leftCommon != null ? leftCommon : rightCommon);
    }
}
