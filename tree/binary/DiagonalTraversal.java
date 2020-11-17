package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTraversal {
    public static void main(String[] args) {

        /*
         *                  9
         *              /      \
         *            2         6
         *          /   \      /
         *        5       3   4
         *      /       /  \
         *    1       8      7
         */
        Node root = TreeUtil.binaryTree1();
        diagonalTraversal(root);
    }

    /**
     * Print the diagonal traversal of a binary tree
     *
     * @param root root of the binary tree
     */
    private static void diagonalTraversal(Node root) {
        Queue<Node> queue = new LinkedList();
        Node temp = root;
        /*
          First add all the right node into the queue
          this is the 1st diagonal
          Note if we had to print another diagonal, we should have stored all the left
         */
        while (temp != null) {
            queue.add(temp);
            temp = temp.getRight();
        }

        while (!queue.isEmpty()) {
            //This size will just help to print the diagonal per line
            int size = queue.size();
            while (size > 0) {
                Node current = queue.poll();
                /*Take out the first node of diagonal in queue
                  Print the current diagonal node
                  save left node or current node
                  Note for other diagonal we would have saved right node
                 */
                System.out.print(current.getData() + " ");
                temp = current.getLeft();
                //save all the right node of this left node
                while (temp != null) {
                    queue.add(temp);
                    temp = temp.getRight();
                }
                size--;
            }
            System.out.println();
        }
    }
}
