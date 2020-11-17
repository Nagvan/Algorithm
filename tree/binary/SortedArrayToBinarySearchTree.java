package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

public class SortedArrayToBinarySearchTree {
    public static void main(String[] args) {
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8};
        Node root = sortedArrayToBST(sortedArray, 0, sortedArray.length - 1);
        TreeUtil.inorder(root);

        System.out.println();
        int[] sortedArray2 = {1, 2, 3, 4, 5, 6, 7, 8,9};
        root = sortedArrayToBST(sortedArray2, 0, sortedArray2.length - 1);
        TreeUtil.inorder(root);
    }

    /**
     * Convert sorted array to Binary Search Tree
     * @param sortedArray sorted array to be converted to Binary Search Tree
     * @param left left limit of subtree
     * @param right right limit of subtree
     * @return root of the converted Binary Search Tree
     */
    private static Node sortedArrayToBST(final int[] sortedArray, int left, int right) {
        //This indicates there is no subtree to be processed
        if (left > right) {
            return null;
        }
        //mid is the root of the tree, so create a node with mid item
        int mid = (left + right) / 2;
        Node root = new Node(sortedArray[mid]);
        //this indicates there is only 1 node in the subtree, so just return the root
        if (left == right) {
            return root;
        }
        /*
           all the left of mid are left subtree
           all the right of mid are right subtree
           so recursively build left and right subtree
         */
        root.setLeft(sortedArrayToBST(sortedArray, left, mid - 1));
        root.setRight(sortedArrayToBST(sortedArray, mid + 1, right));
        return root;
    }
}
