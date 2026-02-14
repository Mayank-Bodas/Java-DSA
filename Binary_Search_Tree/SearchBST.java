package Binary_Search_Tree;

public class SearchBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Solution {
        /*
         * Pseudocode (Search in BST - O(H)):
         * 1. If root is null, return null (Not Found).
         * 2. If root.data == val, return root (Found).
         * 3. If root.data > val, search Left subtree.
         * 4. If root.data < val, search Right subtree.
         */
        public Node searchBST(Node root, int val) {
            // Base Case: Root is null or key is present at root
            if (root == null || root.data == val) {
                return root;
            }

            // Key is smaller than root's key -> Left
            if (root.data > val) {
                return searchBST(root.left, val);
            }

            // Key is greater than root's key -> Right
            return searchBST(root.right, val);
        }

        // Iterative Approach (Space O(1))
        public Node searchBSTIterative(Node root, int val) {
            while (root != null && root.data != val) {
                root = (root.data > val) ? root.left : root.right;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        // Constructing BST
        // 4
        // / \
        // 2 7
        // / \
        // 1 3
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);

        Solution sl = new Solution();
        int target = 2;
        Node found = sl.searchBST(root, target);
        System.out.println("Search " + target + ": " + (found != null ? "Found" : "Not Found"));

        target = 5;
        found = sl.searchBSTIterative(root, target);
        System.out.println("Search " + target + ": " + (found != null ? "Found" : "Not Found"));
    }
}
