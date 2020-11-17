package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

public class RootToLeafSumPath {
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
        System.out.println(hasPathSum(root, 26)); //7 -> 9 -> 8

    }

    /**
     * Find if there exist any path from root to leaf, who's path sum is equal to given sum
     *
     * @param root root of the tree
     * @param sum  sum of the path from root to leaf
     * @return true if there exist any path with given sum, else false
     */
    public static boolean hasPathSum(Node root, int sum) {
        if (root == null) {
            return false;
        }
        //if we reach a leaf, and leaf value is equal to sum, then we have found tha path
        if (root.getData().equals(sum) && root.getLeft() == null && root.getRight() == null) {
            return true;
        }
        //recursively find on left and right, with sum less than current root sum.
        boolean leftPath = hasPathSum(root.getLeft(), sum - (Integer) root.getData());
        boolean rightPath = hasPathSum(root.getRight(), sum - (Integer) root.getData());

        //return true is there exist any path either on left or the right subtree
        return leftPath || rightPath;
    }
}
