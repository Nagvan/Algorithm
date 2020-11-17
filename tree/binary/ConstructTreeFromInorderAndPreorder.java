package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

import java.util.Arrays;
import java.util.List;

public class ConstructTreeFromInorderAndPreorder {
    private static int preIndex = 0;

    public static void main(String[] args) {
        List<Integer> preorder = Arrays.asList(1, 2, 3);
        List<Integer> inorder = Arrays.asList(2, 1, 3);
        Node root = buildTreeUtil(preorder, inorder, 0, preorder.size() - 1);
        TreeUtil.postorder(root);

    }

    /**
     * Build tree from inorder and preorder traversal
     *
     * @param preorder preorder array traversal of the tree
     * @param inorder inorder array traversal of the tree
     * @param left     left limit of subtree to be constructed
     * @param right    right limit of subtree to be constructed
     * @return root of the tree constructed using inorder and preorder traversal
     */
    private static Node buildTreeUtil(List<Integer> preorder, List<Integer> inorder, int left, int right) {
        //left boundary should not be more than right boundary, i.e. the subtree size is zero
        if (left > right) {
            return null;
        }
        //preorder 1st item is always root
        int preValue = preorder.get(preIndex++);
        Node root = new Node(preValue);
        //if we have only 1 item in the subtree just return the root.
        if (left == right) {
            return root;
        }
        //find the corresponding item in inorder traversal
        int index = getRootInorderIndex(inorder, left, right, preValue);
        /*
           in inorder root lies between left and right subtree,
           so recursively construct left subtree and assign the left subtree as left of the root
           and recursively construct right subtree and assign the right subtree as right of the root
         */
        root.setLeft(buildTreeUtil(preorder, inorder, left, index - 1));
        root.setRight(buildTreeUtil(preorder, inorder, index + 1, right));

        return root;
    }

    /**
     * Function to find the node in inorder traversal
     *
     * @param inorder  inorder array traversal
     * @param left     left limit of the inorder
     * @param right    right limit of the inorder
     * @param preValue value of node (here it is preorder root) to be found
     * @return return the index of the node( preorder root) in inorder array traversal
     */
    private static int getRootInorderIndex(List<Integer> inorder, int left, int right, int preValue) {
        for (int i = left; i <= right; i++) {
            if (preValue == inorder.get(i)) {
                return i;
            }
        }
        return left;
    }
}
