package Binary_Tree.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthBT {
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
        // Approach 1: Iterative using Level Order Traversal (BFS)
        /*
         * Pseudocode (BFS - Level Order):
         * 1. If root is null, return 0.
         * 2. Init Queue, add root, level = 0.
         * 3. Loop while queue not empty:
         * a. Get current level size.
         * b. Process all nodes in current level (add children to queue).
         * c. Increment level.
         * 4. Return level.
         */
        int maxDepthBFS(Node root) {
            if (root == null)
                return 0;

            Queue<Node> q = new LinkedList<>();
            q.add(root);
            int level = 0;

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node front = q.poll();
                    if (front.left != null)
                        q.add(front.left);
                    if (front.right != null)
                        q.add(front.right);
                }
                level++;
            }
            return level;
        }

        // Approach 2: Recursive (DFS) - Often simpler
        /*
         * Pseudocode (Recursive DFS):
         * 1. If root is null, return 0.
         * 2. LeftDepth = maxDepth(root.left).
         * 3. RightDepth = maxDepth(root.right).
         * 4. Return 1 + max(LeftDepth, RightDepth).
         */
        int maxDepthRecursive(Node root) {
            if (root == null)
                return 0;

            int leftDepth = maxDepthRecursive(root.left);
            int rightDepth = maxDepthRecursive(root.right);

            return 1 + Math.max(leftDepth, rightDepth);
        }
    }

    public static void main(String[] args) {
        // Creating a simple tree:
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        Solution sl = new Solution();
        System.out.println("Max Depth (BFS): " + sl.maxDepthBFS(root)); // Output: 3
        System.out.println("Max Depth (Recursive): " + sl.maxDepthRecursive(root)); // Output: 3
    }
}
