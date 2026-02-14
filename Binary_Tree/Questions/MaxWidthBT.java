package Binary_Tree.Questions;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthBT {
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

    // Helper class for BFS queue
    static class Pair {
        Node node;
        int num;

        Pair(Node node, int num) {
            this.node = node;
            this.num = num;
        }
    }

    static class Solution {
        /*
         * Pseudocode (Max Width of Binary Tree - O(N)):
         * 1. If root is null, return 0.
         * 2. Initialize Queue with Pair(root, 0).
         * 3. Loop while queue not empty:
         * a. Get current level size.
         * b. Get index of first node in this level (mmin).
         * c. Iterate through nodes:
         * i. Calculate current index relative to mmin (cur_id = num - mmin).
         * ii. If i==0, first = cur_id. If i==size-1, last = cur_id.
         * iii. Add children to queue:
         * - Left: 2 * cur_id + 1
         * - Right: 2 * cur_id + 2
         * d. Update ans = max(ans, last - first + 1).
         * 4. Return ans.
         */
        public int widthOfBinaryTree(Node root) {
            if (root == null)
                return 0;

            int ans = 0;
            Queue<Pair> q = new LinkedList<>();
            q.offer(new Pair(root, 0));

            while (!q.isEmpty()) {
                int size = q.size();
                int mmin = q.peek().num; // Minimum index at current level
                int first = 0, last = 0;

                for (int i = 0; i < size; i++) {
                    int cur_id = q.peek().num - mmin; // Normalize to prevent overflow
                    Node node = q.peek().node;
                    q.poll();

                    if (i == 0)
                        first = cur_id;
                    if (i == size - 1)
                        last = cur_id;

                    if (node.left != null) {
                        q.offer(new Pair(node.left, cur_id * 2 + 1));
                    }
                    if (node.right != null) {
                        q.offer(new Pair(node.right, cur_id * 2 + 2));
                    }
                }
                ans = Math.max(ans, last - first + 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        // Example 1:
        // 1
        // / \
        // 3 2
        // / \ \
        // 5 3 9
        // Width: Level 3 indices: 5(0), 3(1), 9(3). Width = 3-0+1 = 4.
        Node root = new Node(1);
        root.left = new Node(3);
        root.right = new Node(2);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.right.right = new Node(9);

        Solution sl = new Solution();
        System.out.println("Max Width: " + sl.widthOfBinaryTree(root)); // Output: 4
    }
}
