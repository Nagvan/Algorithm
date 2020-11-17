package tree.binary;

import tree.entity.Node;
import tree.util.TreeUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class VerticalTraversal {
    public static void main(String[] args) {
        //Use tree map to store the vertical level in order
        Map<Integer, ArrayList<Object>> verticalMap = new TreeMap<>();
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
        verticalOrder(root, verticalMap);
        System.out.println("Printing vertical traversal of tree");
        verticalMap.values().forEach(System.out::println);

        verticalMap = new TreeMap<>();
        /*
         *                  7
         *              /      \
         *            3         9
         *          /   \      /  \
         *        2      5   8     10
         *             /  \
         *           4      6
         */
        root = TreeUtil.binarySearchTree1();
        verticalOrder(root, verticalMap);
        System.out.println("Printing vertical traversal of tree");
        verticalMap.values().forEach(System.out::println);
    }

    /**
     * stores the vertical traversal of a binary tree in a map
     * Note: if we don't use queue to do level order traversal, we will get vertical traversal, but the node in those verticals may be unordered
     * Time complexity O(n)
     * Space complexity O(n)
     * @param root        root of the tree
     * @param verticalMap map to store the vertical traversal, use tree map to store those verticals in order
     */
    private static void verticalOrder(Node root, Map<Integer, ArrayList<Object>> verticalMap) {
        if (root == null) {
            return;
        }
        Queue<NodeMap> queue = new LinkedList();
        //store root at horizontal distance 0
        queue.add(new NodeMap(root, 0));
        while (!queue.isEmpty()) {
            NodeMap temp = queue.poll();
            //If this horizontal distance was already traversed before, just add current node to it
            if (verticalMap.containsKey(temp.hd)) {
                verticalMap.get(temp.hd).add(temp.node.getData());
            } else {
                //if this new horizontal distance is discovered add new entry into map, with this node as start of the level
                verticalMap.put(temp.hd, new ArrayList<>(Collections.singletonList(temp.node.getData())));
            }
            /*add left and right of the current node if present to queue
              for every left child horizontal distance will be 1 less than current horizontal distance
              for every right child horizontal distance will be 1 more than current horizontal distance
             */
            if (temp.node.getLeft() != null) {
                queue.add(new NodeMap(temp.node.getLeft(), temp.hd - 1));
            }
            if (temp.node.getRight() != null) {
                queue.add(new NodeMap(temp.node.getRight(), temp.hd + 1));
            }
        }
    }

    //This is an object used to store in queue, coz we also want to store the horizontal distance along with the node itself
    static class NodeMap {
        Node node;
        int hd;

        NodeMap(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
}
