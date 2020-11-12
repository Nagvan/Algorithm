package tree.util;

import tree.entity.Node;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
    private final static String EMPTY_STRING = " ";

    private TreeUtil() {
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.getLeft());
        System.out.print(root.getData() + EMPTY_STRING);
        inorder(root.getRight());
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.getData() + EMPTY_STRING);
        preorder(root.getLeft());
        preorder(root.getRight());
    }

    public static void postorder(Node root) {
        if (root == null) {
            return;
        }
        postorder(root.getLeft());
        postorder(root.getRight());
        System.out.print(root.getData() + EMPTY_STRING);
    }

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                Node current = queue.poll();
                System.out.print(current.getData() + EMPTY_STRING);
                if(current.getLeft() != null){
                    queue.add(current.getLeft());
                }
                if(current.getRight() != null){
                    queue.add(current.getRight());
                }
                size--;
            }
            System.out.println();
        }
    }

    public static int height(Node root){
        if(root == null){
            return 0;
        }
        return Math.max(height(root.getLeft()), height(root.getRight())) + 1;
    }

    public static int size(Node root){
        if(root == null){
            return 0;
        }
        return size(root.getLeft()) + size(root.getRight()) + 1;
    }

    /**
     *                  9
     *              /      \
     *            2         6
     *          /   \      /
     *        5       3   4
     *      /       /  \
     *    1       8      7
     * @return binary Tree
     */
    public static Node binaryTree1(){
        Node node8 = new Node(7);
        Node node7 = new Node(8);
        Node node6 = new Node(1);
        Node node5 = new Node(4);
        Node node4 = new Node(3);
        Node node3 = new Node(5);
        Node node2 = new Node(6);
        Node node1 = new Node(2);
        Node root = new Node(9);

        root.setLeft(node1);
        root.setRight(node2);

        node1.setLeft(node3);
        node1.setRight(node4);

        node2.setLeft(node5);

        node3.setLeft(node6);

        node4.setLeft(node7);
        node4.setRight(node8);

        return root;
    }
}
