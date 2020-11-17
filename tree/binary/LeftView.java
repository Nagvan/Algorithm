package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

public class LeftView {
    private static int maxLevel = 0;

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
        System.out.println("Printing left view");
        Node root = TreeUtil.binaryTree1();
        printLeftView(root, 1);

        maxLevel = 0;
        System.out.println("Printing left view");
        /*
         *                  7
         *              /      \
         *            3         9
         *          /   \      /  \
         *        2      5   8     10
         *             /  \
         *           4      6
         */
        root = TreeUtil.binarySearchTree1();
        printLeftView(root, 1);
    }

    /**
     * Print the left view of a binary tree
     * We could have done the same using queue, to travel each level
     * and only print the 1st node of each level, but that would have taken space O(n)
     * Time complexity O(n)
     * Space complexity O(1)
     *
     * @param root         root of the binary tree
     * @param currentLevel current level of the binary tree
     */
    private static void printLeftView(Node root, int currentLevel) {
        if (root == null) {
            return;
        }
        /*if this level is 1st time visited, print the node, also update the maxLevel traversed to this level
          Note since we are going to left subtree 1st then right subtree
          so we are doing left to right traversal, and if we have reached to new level
          1st element will be the left most element
         */
        if (currentLevel > maxLevel) {
            System.out.println(root.getData());
            maxLevel = currentLevel;
        }
        //recursively traverse for left and right subtree
        printLeftView(root.getLeft(), currentLevel + 1);
        printLeftView(root.getRight(), currentLevel + 1);
    }
}
