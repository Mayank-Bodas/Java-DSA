package Binary_Tree.Questions;

public class MaxSumPathBT {
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
        int maxSum = Integer.MIN_VALUE;

        /*
         * Pseudocode (Max Path Sum in Binary Tree - O(N)):
         * 1. Initialize global maxSum to very small value.
         * 2. Call helper function dfs(root).
         * 3. Return maxSum.
         * 
         * Helper dfs(node):
         * 1. If node is null, return 0.
         * 2. LeftMax = max(0, dfs(node.left)). (Ignore negative sums).
         * 3. RightMax = max(0, dfs(node.right)).
         * 4. Update maxSum = max(maxSum, LeftMax + RightMax + node.data).
         * 5. Return node.data + max(LeftMax, RightMax).
         */
        public int maxPathSum(Node root) {
            dfs(root);
            return maxSum;
        }

        private int dfs(Node node) {
            if (node == null)
                return 0;

            // Calculate max path sum going down left and right subtrees
            // Ignore paths with negative sums (take 0 instead)
            int left = Math.max(0, dfs(node.left));
            int right = Math.max(0, dfs(node.right));

            // Update global maximum path sum (path through current node)
            maxSum = Math.max(maxSum, left + right + node.data);

            // Return max path sum extendable to parent
            return Math.max(left, right) + node.data;
        }
    }

    public static void main(String[] args) {
        // Example 1:
        // 1
        // / \
        // 2 3
        // Result: 6 (2+1+3)
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Solution sl = new Solution();
        System.out.println("Max Path Sum 1: " + sl.maxPathSum(root1)); // 6

        // Example 2:
        // -10
        // / \
        // 9 20
        // / \
        // 15 7
        // Result: 42 (15 + 20 + 7)
        Node root2 = new Node(-10);
        root2.left = new Node(9);
        root2.right = new Node(20);
        root2.right.left = new Node(15);
        root2.right.right = new Node(7);

        // Use a new instance as maxSum is instance variable
        Solution sl2 = new Solution();
        System.out.println("Max Path Sum 2: " + sl2.maxPathSum(root2)); // 42
    }
}
