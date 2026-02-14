package Binary_Tree.Intro;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Levelorder {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Solution {
        /*
         * Pseudocode (Level Order Traversal - Level by Level):
         * 1. If root is null, return empty list.
         * 2. Initialize Queue, add root.
         * 3. Loop while queue is not empty:
         * a. Get 'size' of queue (number of nodes at current level).
         * b. Create 'currentLevel' list.
         * c. Loop 'size' times:
         * i. Poll node.
         * ii. Add node.data to 'currentLevel'.
         * iii. Add children to queue.
         * d. Add 'currentLevel' to 'result'.
         */
        public List<List<Integer>> levelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                List<Integer> currentLevel = new ArrayList<>();

                for (int i = 0; i < levelSize; i++) {
                    Node node = queue.poll();
                    currentLevel.add(node.data);

                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }
                result.add(currentLevel);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // Creating a simple tree:
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Solution sl = new Solution();
        List<List<Integer>> result = sl.levelOrder(root);

        System.out.println("Level Order Traversal (Level-by-Level): " + result);
        // Expected: [[1], [2, 3], [4, 5]]
    }
}
