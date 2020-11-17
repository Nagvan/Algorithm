package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

public class SymmetricTree {
    public static void main(String[] args) {
        Node root = TreeUtil.binaryTree1();
        System.out.println(isSymmetric(root));
    }

    /**
     * Check if root is symmetric
     * i.e. left and right subtree are identical
     * @param root root of the tree
     * @return true if the tree is symmetric, else false
     */
    private static boolean isSymmetric(Node root){
        if(root == null){
            return true;
        }
        return isSymmetricUtil(root.getLeft(), root.getRight());
    }

    /**
     * Check if left and right subtree are identical
     * @param left left subtree
     * @param right right subtree
     * @return true is left and right subtree are identical, else false
     */
    private static boolean isSymmetricUtil(Node left, Node right){
        //either both left and right are null,
        if(left == null && right == null){
            return true;
        }else if(left != null && right != null){
            /*
               or both subtree are present and data of both the root of left and right subtree are same
               and left and right subtree of these two roots, left and right are also identical
               then both left and right subtree are identical
             */
            return left.getData() == right.getData()
                    && isSymmetricUtil(left.getLeft(), right.getRight())
                    && isSymmetricUtil(left.getRight(), right.getLeft());
        }else {
            return false;
        }
    }
}
