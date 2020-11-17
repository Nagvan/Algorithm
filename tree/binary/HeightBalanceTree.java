package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

public class HeightBalanceTree {
    public static void main(String[] args) {
        Node root = TreeUtil.binaryTree1();
        System.out.println(isHeightBalanced(root, new Height()));

    }

    /**
     * Find if the tree is height balanced,
     * i.e.difference between left subtree height and right subtree is max 1
     * @param root root of the tree
     * @param h holds the height of the tree
     * @return true if tree is height balance, else false
     */
    private static boolean isHeightBalanced(Node root, Height h){
        if(root == null){
            return true;
        }
        Height left = new Height();
        Height right = new Height();
        boolean leftHeight = isHeightBalanced(root.getLeft(), left);
        boolean rightHeight = isHeightBalanced(root.getRight(), right);

        if(Math.abs(left.height - right.height) > 1){
            return false;
        }

        h.height = Math.max(left.height, right.height) + 1;
        return leftHeight && rightHeight;

    }

    public static class Height{
        int height;
        Height(){
            height = 0;
        }
    }
}
