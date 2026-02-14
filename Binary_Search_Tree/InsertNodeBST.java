package Binary_Search_Tree;

public class InsertNodeBST {
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
         * Pseudocode (Insert Node in BST - O(H)):
         * 1. If root is null, create and return a new Node(val).
         * 2. If val < root.data, recursively insert into Left subtree.
         * root.left = insert(root.left, val).
         * 3. If val > root.data, recursively insert into Right subtree.
         * root.right = insert(root.right, val).
         * 4. Return root.
         */
        public Node insert(Node root, int val) {
            if (root == null) {
                return new Node(val);
            }

            if (val < root.data) {
                root.left = insert(root.left, val);
            } else if (val > root.data) {
                root.right = insert(root.right, val);
            }
            // If val == root.data, we do nothing (BST usually doesn't allow duplicates),
            // return root.

            return root;
        }

        // Helper method to print Inorder traversal (for verification)
        public void inorder(Node root) {
            if (root == null)
                return;
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
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
        int newVal = 5;
        System.out.println("Inserting " + newVal + "...");
        root = sl.insert(root, newVal);

        System.out.print("Inorder Traversal after Insertion: ");
        sl.inorder(root); // Expected: 1 2 3 4 5 7
        System.out.println();
    }
}
