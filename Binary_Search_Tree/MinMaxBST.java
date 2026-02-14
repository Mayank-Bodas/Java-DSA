package Binary_Search_Tree;

public class MinMaxBST {
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
         * Pseudocode (Find Minimum in BST - O(H)):
         * 1. If root is null, return -1 (or throw exception).
         * 2. Traverse to the leftmost node (root = root.left).
         * 3. Return leftmost node's data.
         */
        public int minValue(Node root) {
            if (root == null)
                return -1; // Or throw exception

            while (root.left != null) {
                root = root.left;
            }
            return root.data;
        }

        /*
         * Pseudocode (Find Maximum in BST - O(H)):
         * 1. If root is null, return -1.
         * 2. Traverse to the rightmost node (root = root.right).
         * 3. Return rightmost node's data.
         */
        public int maxValue(Node root) {
            if (root == null)
                return -1; // Or throw exception

            while (root.right != null) {
                root = root.right;
            }
            return root.data;
        }
    }

    public static void main(String[] args) {
        // Constructing BST
        // 5
        // / \
        // 3 8
        // / \ \
        // 1 4 9
        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(4);
        root.right.right = new Node(9);

        Solution sl = new Solution();
        System.out.println("Minimum Value: " + sl.minValue(root)); // Output: 1
        System.out.println("Maximum Value: " + sl.maxValue(root)); // Output: 9
    }
}
