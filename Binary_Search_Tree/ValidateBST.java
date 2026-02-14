package Binary_Search_Tree;

public class ValidateBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Solution {
        /**
         * Validates if a binary tree is a Binary Search Tree (BST).
         * 
         * Algorithm (Recursive Range Approach):
         * 1. Define a helper function 'isValid' that takes a node and a valid range
         * (min, max).
         * 2. Base Case: If the node is null, return true (an empty tree is a valid
         * BST).
         * 3. Check Constraints:
         * a. If min is not null and node.data <= min, return false.
         * b. If max is not null and node.data >= max, return false.
         * 4. Recursive Step:
         * a. recursively check the left subtree with updated max range (min,
         * node.data).
         * b. recursively check the right subtree with updated min range (node.data,
         * max).
         * c. Return true only if both recursive calls return true.
         * 
         * Time Complexity: O(N), where N is the number of nodes (we visit each node
         * once).
         * Space Complexity: O(H), where H is the height of the tree (recursion stack).
         */
        public boolean isValidBST(Node root) {
            return isValid(root, null, null);
        }

        private boolean isValid(Node node, Integer min, Integer max) {
            // Base case: An empty tree is a valid BST
            if (node == null) {
                return true;
            }

            // Check if the current node's value is within the valid range
            // If min is set, node.data must be strictly greater than min
            if (min != null && node.data <= min) {
                return false;
            }
            // If max is set, node.data must be strictly less than max
            if (max != null && node.data >= max) {
                return false;
            }

            // Recursively validate left and right subtrees
            // For left subtree: max value becomes current node's data
            // For right subtree: min value becomes current node's data
            return isValid(node.left, min, node.data) && isValid(node.right, node.data, max);
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();

        // Case 1: Valid BST
        // 2
        // / \
        // 1 3
        Node root1 = new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(3);
        System.out.println("Tree 1 is valid BST: " + sl.isValidBST(root1)); // Expected: true

        // Case 2: Invalid BST (Right child is smaller than root)
        // 5
        // / \
        // 1 4
        // / \
        // 3 6
        Node root2 = new Node(5);
        root2.left = new Node(1);
        root2.right = new Node(4);
        root2.right.left = new Node(3);
        root2.right.right = new Node(6);
        System.out.println("Tree 2 is valid BST: " + sl.isValidBST(root2)); // Expected: false

        // Case 3: Invalid BST (Left child in right subtree is smaller than root)
        // 5
        // / \
        // 4 6
        // / \
        // 3 7
        // Node 3 is in the right subtree of 5 but is smaller than 5.
        Node root3 = new Node(5);
        root3.left = new Node(4);
        root3.right = new Node(6);
        root3.right.left = new Node(3);
        root3.right.right = new Node(7);
        System.out.println("Tree 3 is valid BST: " + sl.isValidBST(root3)); // Expected: false
    }
}
