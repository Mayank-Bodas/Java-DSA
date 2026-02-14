package Binary_Search_Tree;

public class DeleteNodeBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Solution {
        /**
         * Deletes a node with the given value from the BST.
         * 
         * Algorithm (Pseudocode):
         * 1. Search for the node to delete:
         * a. If root is null, return null (Base case).
         * b. If val < root.data, recurse on the left subtree.
         * c. If val > root.data, recurse on the right subtree.
         * 
         * 2. If node is found (root.data == val):
         * a. Case 1: Node has no children (Leaf node).
         * - Return null.
         * b. Case 2: Node has only one child.
         * - If left child is null, return right child.
         * - If right child is null, return left child.
         * c. Case 3: Node has two children.
         * - Find the Inorder Successor (smallest node in the right subtree).
         * - Replace the current node's value with the successor's value.
         * - Delete the successor node from the right subtree recursively.
         * 
         * 3. Return the modified root.
         */
        public Node delete(Node root, int val) {
            if (root == null) {
                return null;
            }

            // Search step
            if (val < root.data) {
                root.left = delete(root.left, val);
            } else if (val > root.data) {
                root.right = delete(root.right, val);
            } else {
                // Node found

                // Case 1 & 2: No child or One child
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                }

                // Case 3: Two children
                // Find inorder successor (smallest in the right subtree)
                Node successor = findMin(root.right);

                // Replace root's data with successor's data
                root.data = successor.data;

                // Delete the inorder successor from the right subtree
                // We call delete specifically on the right subtree to remove the duplicate
                // successor value
                root.right = delete(root.right, successor.data);
            }
            return root;
        }

        // Helper method to find the minimum value node in a subtree
        private Node findMin(Node node) {
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }

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
        // / \ /
        // 1 3 6

        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(7);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        root.right.left = new Node(6);

        Solution sl = new Solution();
        System.out.print("Inorder traversal before deletion: ");
        sl.inorder(root);
        System.out.println();

        // Test cases
        int key = 2; // Node with two children
        System.out.println("\nDeleting node with value: " + key);
        root = sl.delete(root, key);
        System.out.print("Inorder traversal after deleting " + key + ": ");
        sl.inorder(root);
        System.out.println();

        key = 4; // Root node
        System.out.println("\nDeleting node with value: " + key);
        root = sl.delete(root, key);
        System.out.print("Inorder traversal after deleting " + key + ": ");
        sl.inorder(root);
        System.out.println();

        key = 6; // Leaf node
        System.out.println("\nDeleting node with value: " + key);
        root = sl.delete(root, key);
        System.out.print("Inorder traversal after deleting " + key + ": ");
        sl.inorder(root);
        System.out.println();
    }
}
