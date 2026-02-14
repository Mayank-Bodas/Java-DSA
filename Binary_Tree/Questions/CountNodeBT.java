package Binary_Tree.Questions;

public class CountNodeBT {
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
         * Pseudocode (Count Nodes in Binary Tree - O(N)):
         * 1. If root is null, return 0.
         * 2. Return 1 + count(left) + count(right).
         * 
         * Note: If the tree is a Complete Binary Tree, we can optimize to O(logN *
         * logN).
         * But for general Binary Tree, O(N) is optimal as we must visit every node.
         */
        public int countNode(Node root) {
            if (root == null)
                return 0;
            return 1 + countNode(root.left) + countNode(root.right);
        }

        // Alternative: Iterative using Size or Traversal (User's original approach uses
        // array reference)
        public int countNodeInorder(Node root) {
            int[] count = new int[1];
            inorder(root, count);
            return count[0];
        }

        private void inorder(Node root, int[] count) {
            if (root == null)
                return;
            count[0]++;
            inorder(root.left, count);
            inorder(root.right, count);
        }
    }

    public static void main(String[] args) {
        // Example:
        // 1
        // / \
        // 2 3
        // / \
        // 4 5
        // Count: 5
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        Solution sl = new Solution();
        System.out.println("Node Count (Recursive): " + sl.countNode(root)); // Output: 5
        System.out.println("Node Count (Inorder): " + sl.countNodeInorder(root)); // Output: 5
    }
}
