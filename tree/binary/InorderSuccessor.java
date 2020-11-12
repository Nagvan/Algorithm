package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

public class InorderSuccessor {
    public static void main(String[] args) {
        Node root = TreeUtil.binaryTree1();
        TreeUtil.inorder(root);
        System.out.println();

        int data = 9;
        Node successor = inorderSuccessor(root, data, new Previous());
        System.out.println("inorder success of "+ data + " is: "+ successor.getData());

        data = 7;
        successor = inorderSuccessor(root, data, new Previous());
        System.out.println("inorder success of "+ data + " is: "+ successor.getData());

        data = 1;
        successor = inorderSuccessor(root, data, new Previous());
        System.out.println("inorder success of "+ data + " is: "+ successor.getData());

        data = 6;
        successor = inorderSuccessor(root, data, new Previous());
        System.out.println("inorder success of "+ data + " is: "+ (successor == null? "NULL" : successor.getData()));

        System.out.println("Printing inorder successor of all nodes");
        printAllInorderSuccessor(root, new Previous());
    }

    /**
     * Function to find the inorder success of a given node
     * Time complexity O(n)
     * Space Complexity O(1)
     * @param root root of the tree
     * @param data value of the node who's inorder successor we want to find
     * @param pre previous node, to keep track the last visited node in inorder traversal
     * @return Inorder successor node of the given node
     */
    private static Node inorderSuccessor(Node root, int data, Previous pre){
        if(root == null){
            return null;
        }

        /*
            Do reverse inorder traversal, i.e. right 1st
            Why?
            Inorder success will come after the given node.
            If we travel from left we can store inorder predecessor, but successor will come after the node.
            So travel from right 1st. And if the current node is the given node.
            Previous node will contain the successor of the given node.
         */
        Node rightSuccessor = inorderSuccessor(root.getRight(), data, pre);

        /*
            If root data matches the given node value.
            Previous would have stored the inorder successor, so just return the previous Node
         */
        if(pre != null && root.getData().equals(data)){
            return pre.prev;
        }
        //make the current root as previous for next iteration
        pre.prev = root;
        Node leftSuccessor = inorderSuccessor(root.getLeft(), data, pre);
        //either leftSuccessor or rightSuccessor will have the result
        return leftSuccessor == null ? rightSuccessor : leftSuccessor;
    }

    /**
     * Function to print the inorder successor of all the nodes of a tree
     * Time complexity O(n)
     * Space complexity O(1)
     * @param root root of the binary tree
     * @param pre previous node, to store the successor of a node
     */
    private static void printAllInorderSuccessor(Node root, Previous pre){
        if(root == null){
            return;
        }
        printAllInorderSuccessor(root.getRight(), pre);
        System.out.println("inorder success of "+ root.getData() + " is: "+ (pre == null || pre.prev == null ? "NULL" : pre.prev.getData()));
        pre.prev = root;
        printAllInorderSuccessor(root.getLeft(), pre);
    }

    /**This is to make sure that same previous is changed by both left and right recursion
     * The same can be achieved using static variable
     */
    static class Previous{
        Node prev;
    }
}
