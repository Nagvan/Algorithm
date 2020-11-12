package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

public class MinHeight {
    public static void main(String[] args) {
        Node root = TreeUtil.binaryTree1();
        int minHeight = minDepth(root);
        System.out.println(minHeight);

        //Tree is null
        System.out.println(minDepth(null));
    }

    /**
     * Function to find the minimum height of the tree, i.e. nearest leaf node from the root
     * Time complexity O(n)
     * Space complexity O(1)
     * @param root root of the binary tree
     * @return minimum height of the binary tree
     */
    private static int minDepth(Node root) {
        if (root == null) {
            return 0;
        } else if (root.getLeft() == null && root.getRight() == null) {
            return 1;
        } else if (root.getLeft() == null) {
            return minDepth(root.getRight()) + 1;
        } else if (root.getRight() == null) {
            return minDepth(root.getLeft()) + 1;
        }
        int leftMin = minDepth(root.getLeft());
        int rightMin = minDepth(root.getRight());
        return Math.min(leftMin, rightMin) + 1;
    }
}
