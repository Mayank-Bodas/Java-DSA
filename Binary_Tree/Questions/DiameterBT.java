package Binary_Tree.Questions;

public class DiameterBT {
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
         * Pseudocode (Diameter of Binary Tree - O(N)):
         * 1. Initialize diameter array int[1] to store max diameter found.
         * 2. Call helper function 'height(root, diameter)'.
         * 3. Return diameter[0].
         * 
         * Helper 'height(node, diameter)':
         * 1. If node is null, return 0.
         * 2. LeftHeight = height(node.left, diameter).
         * 3. RightHeight = height(node.right, diameter).
         * 4. Update diameter[0] = max(diameter[0], LeftHeight + RightHeight).
         * 5. Return 1 + max(LeftHeight, RightHeight).
         */
        public int diameterOfBinaryTree(Node root) {
            int[] diameter = new int[1];
            height(root, diameter);
            return diameter[0];
        }

        private int height(Node node, int[] diameter) {
            if (node == null)
                return 0;

            int lh = height(node.left, diameter);
            int rh = height(node.right, diameter);

            // Update the diameter with the path passing through this node
            diameter[0] = Math.max(diameter[0], lh + rh);

            // Return height of current node
            return 1 + Math.max(lh, rh);
        }
    }

    public static void main(String[] args) {
        // Example 1:
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
        System.out.println("Diameter of Tree: " + sl.diameterOfBinaryTree(root)); // Output: 3 (Path: 4-2-1-3 or
                                                                                  // 5-2-1-3)
    }
}
