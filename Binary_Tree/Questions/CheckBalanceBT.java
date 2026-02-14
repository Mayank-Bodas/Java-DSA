package Binary_Tree.Questions;

public class CheckBalanceBT {
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
         * Pseudocode (Is Balanced - O(N) Optimized):
         * 1. Use a helper function 'dfsHeight' that returns height if balanced, or -1
         * if unbalanced.
         * 2. In helper(node):
         * a. If node is null, return 0.
         * b. LeftHeight = helper(node.left).
         * c. RightHeight = helper(node.right).
         * d. If LeftHeight == -1 OR RightHeight == -1 OR abs(Left - Right) > 1:
         * Return -1 (Unbalanced).
         * e. Return 1 + max(Left, Right).
         * 3. Main function calls helper: return helper(root) != -1.
         */
        public boolean isBalanced(Node root) {
            return dfsHeight(root) != -1;
        }

        private int dfsHeight(Node root) {
            if (root == null)
                return 0;

            int leftH = dfsHeight(root.left);
            if (leftH == -1)
                return -1;

            int rightH = dfsHeight(root.right);
            if (rightH == -1)
                return -1;

            if (Math.abs(leftH - rightH) > 1)
                return -1;

            return 1 + Math.max(leftH, rightH);
        }
    }

    public static void main(String[] args) {
        // Example 1: Balanced Tree
        // 3
        // / \
        // 9 20
        // / \
        // 15 7
        Node root1 = new Node(3);
        root1.left = new Node(9);
        root1.right = new Node(20);
        root1.right.left = new Node(15);
        root1.right.right = new Node(7);

        Solution sl = new Solution();
        System.out.println("Tree 1 Balanced? " + sl.isBalanced(root1)); // true

        // Example 2: Unbalanced Tree
        // 1
        // / \
        // 2 2
        // / \
        // 3 3
        // / \
        // 4 4
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.left.left = new Node(3);
        root2.left.left.left = new Node(4);
        root2.right = new Node(2);

        System.out.println("Tree 2 Balanced? " + sl.isBalanced(root2)); // false
    }
}
