package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

import java.util.Arrays;
import java.util.List;

public class ConstructTreeFromInorderAndPostorder {
    private static int postIndex;
    public static void main(String[] args) {
        List<Integer> postorder = Arrays.asList(1, 2, 3);
        List<Integer> inorder = Arrays.asList(2, 1, 3);
        postIndex = inorder.size()-1;
        Node root = buildTreeUtil(inorder, postorder, 0, postorder.size() - 1);
        TreeUtil.preorder(root);
    }

    /**
     * construct tree from inorder and postorder traversal of the tree
     * @param inorder inorder array traversal of the tree
     * @param postorder postorder array traversal of the tree
     * @param left left limit of the subtree to be constructed
     * @param right right limit of the subtree to be constructed
     * @return root of the tree
     */
    private static Node buildTreeUtil(List<Integer> inorder, List<Integer> postorder, int left, int right){
        //left boundary should not be more than right boundary, i.e. the subtree size is zero
        if(left > right){
            return null;
        }
        //preorder last item is always root
        int postValue = postorder.get(postIndex--);
        Node root = new Node(postValue);
        //if we have only 1 item in the subtree just return the root.
        if(left == right){
            return root;
        }
        //find the corresponding item in inorder traversal
        int index = getInorderIndex(inorder, left, right, postValue);
        //Note we populate the right before left subtree, coz int postorder root comes last and we are traversing the postorder array from end
        /*
           in inorder root lies between left and right subtree,
           so recursively construct right subtree and assign the right subtree as left of the root
           and recursively construct left subtree and assign the left subtree as right of the root
         */
        root.setRight( buildTreeUtil(inorder, postorder, index + 1, right));
        root.setLeft(buildTreeUtil(inorder, postorder, left, index-1));

        return root;
    }

    /**
     * Function to find the node in inorder traversal
     *
     * @param inorder  inorder array traversal
     * @param left     left limit of the inorder
     * @param right    right limit of the inorder
     * @param postValue value of node (here it is postorder root) to be found
     * @return return the index of the node( postrder root) in inorder array traversal
     */
    private static int getInorderIndex(List<Integer> inorder, int left, int right, int postValue){
        int index = inorder.size()-1;
        for(int i=right; i>=left; i--){
            if(inorder.get(i) == postValue)
                return i;
        }
        return index;
    }
}
