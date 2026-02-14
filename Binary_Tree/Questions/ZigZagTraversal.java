package Binary_Tree.Questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {
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
         * Pseudocode (ZigZag Level Order Traversal - O(N)):
         * 1. If root is null, return empty list.
         * 2. Initialize Queue with root.
         * 3. Initialize 'leftToRight' boolean flag = true.
         * 4. While queue is not empty:
         * a. Get current level size.
         * b. Create a List for current level (size pre-determined).
         * c. Iterate through nodes at this level:
         * i. Poll node.
         * ii. If leftToRight: add at end (or index i).
         * Else: add at beginning (or index size-1-i).
         * iii. Add logic: Using LinkedList allows addFirst/addLast efficiently.
         * Or just fill an array/list: List[i] vs List[size-1-i].
         * iv. Add children to queue as normal (Left then Right).
         * d. Add level list to result.
         * e. Toggle 'leftToRight'.
         * 5. Return result.
         */
        public List<List<Integer>> zigzagLevelOrder(Node root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null)
                return result;

            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            boolean leftToRight = true;

            while (!queue.isEmpty()) {
                int size = queue.size();
                // Use LinkedList for O(1) insertion at head/tail, or ArrayList + explicit index
                // handling
                // For ArrayList, we can initialize with size and set(index, value), but
                // ArrayList doesn't support sparse.
                // Better: Use LinkedList and addLast/addFirst? Or just ArrayList and construct
                // in order?
                // Constructing in order:
                // If L->R: add(val).
                // If R->L: add(0, val) -> O(K) where K is level width. Worst case O(N) per
                // level -> O(N^2) total?
                // Optimization: Use a temporary array/deque to fill in O(1).

                List<Integer> currentLevel = new ArrayList<>(size);
                // Initialize currentLevel with nulls to allow set(index) - inefficient
                // Best approach: Use LinkedList/Deque? Or simply add to list and then reverse
                // if needed?
                // Reversing is O(K), total O(N). Acceptable.

                for (int i = 0; i < size; i++) {
                    Node node = queue.poll();
                    currentLevel.add(node.data);

                    if (node.left != null)
                        queue.add(node.left);
                    if (node.right != null)
                        queue.add(node.right);
                }

                if (!leftToRight) {
                    Collections.reverse(currentLevel);
                }

                result.add(currentLevel);
                leftToRight = !leftToRight;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        // Example:
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        // ZigZag: [[3], [20, 9], [15, 7]]
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        Solution sl = new Solution();
        List<List<Integer>> result = sl.zigzagLevelOrder(root);

        System.out.println("ZigZag Traversal: " + result);
    }
}
