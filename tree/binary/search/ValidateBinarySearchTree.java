package tree.binary.search;

import tree.entity.Node;
import tree.util.TreeUtil;

public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Node root = TreeUtil.binarySearchTree1();
        //Inorder traversal of binary search tree always gives a sorted array
        TreeUtil.inorder(root);
        boolean isTreeBinarySearch = validateBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(isTreeBinarySearch);

        root = TreeUtil.binaryTree1();
        TreeUtil.inorder(root);
        isTreeBinarySearch = validateBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(isTreeBinarySearch);
    }

    /**
     * Function to identify if the given tree is Binary Search Tree or not
     * Time complexity O(n)
     * space complexity O(1)
     * We can achieve the same by storing the inorder traversal into an array
     * Inorder traversal of a binary search tree is always sorted
     *
     * @param root root of the tree
     * @param min  minimum limit of the node, initially it will be Integer.MIN_VALUE
     * @param max  maximum limit of the node, initially it will be Integer.MAX_VALUE
     * @return true if the tree is Binary Search Tree else false
     */
    private static boolean validateBinarySearchTree(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        /*
           The current node should fall between min and max
           For Left Subtree min will be same as for root, but the max limit will be root.data
           For Right Subtree max will be same as for root, but the min limit will be root.data
         */
        return (Integer) root.getData() > min && (Integer) root.getData() < max
                && validateBinarySearchTree(root.getLeft(), min, (Integer) root.getData())
                && validateBinarySearchTree(root.getRight(), (Integer) root.getData(), max);
    }
}
