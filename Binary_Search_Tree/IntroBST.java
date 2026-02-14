package Binary_Search_Tree;

public class IntroBST {
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

    /*
     * Binary Search Tree (BST) Properties:
     * 1. Left subtree of a node contains only nodes with keys less than the node's
     * key.
     * 2. Right subtree of a node contains only nodes with keys greater than the
     * node's key.
     * 3. Both the left and right subtrees must also be binary search trees.
     * 4. Inorder Traversal of a BST produces sorted output.
     */
    static class Solution {
        // Search in BST (Recursive) - O(H)
        public Node searchBST(Node root, int val) {
            if (root == null || root.data == val)
                return root;

            // If val is less, search left
            if (val < root.data)
                return searchBST(root.left, val);

            // If val is greater, search right
            return searchBST(root.right, val);
        }

        // Search in BST (Iterative) - Space O(1)
        public Node searchBSTIterative(Node root, int val) {
            while (root != null && root.data != val) {
                root = (val < root.data) ? root.left : root.right;
            }
            return root;
        }

        // Insert into BST (Recursive) - O(H)
        public Node insert(Node root, int val) {
            if (root == null) {
                return new Node(val);
            }
            if (val < root.data) {
                root.left = insert(root.left, val);
            } else if (val > root.data) {
                root.right = insert(root.right, val);
            }
            return root;
        }

        // Helper to verify (Inorder Traversal)
        public void inorder(Node root) {
            if (root == null)
                return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        Node root = null;

        // Constructing BST
        // 4
        // / \
        // 2 7
        // / \
        // 1 3
        int[] keys = { 4, 2, 7, 1, 3 };
        for (int key : keys) {
            root = sl.insert(root, key);
        }

        System.out.print("Inorder Traversal (Sorted): ");
        sl.inorder(root); // Expected: 1 2 3 4 7
        System.out.println();

        // Search
        int target = 2;
        Node found = sl.searchBST(root, target);
        System.out.println("Search " + target + ": " + (found != null ? "Found" : "Not Found"));

        target = 5;
        found = sl.searchBSTIterative(root, target);
        System.out.println("Search " + target + ": " + (found != null ? "Found" : "Not Found"));
    }
}
