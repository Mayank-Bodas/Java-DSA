package Binary_Tree.Questions;

public class FlattenBT {
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
        Node prev = null;

        /*
         * Pseudocode (Flatten Binary Tree to Linked List - O(N)):
         * Goal: Root -> Left -> Right (Preorder) flattened to Root -> Right -> Right...
         * Approach: Reverse Postorder (Right -> Left -> Root).
         * 1. Recursively flatten Right subtree.
         * 2. Recursively flatten Left subtree.
         * 3. Set root.right = prev.
         * 4. Set root.left = null.
         * 5. Set prev = root.
         */
        public void flatten(Node root) {
            if (root == null)
                return;

            // 1. Flatten Right Subtree
            flatten(root.right);

            // 2. Flatten Left Subtree
            flatten(root.left);

            // 3. Update Pointers
            root.right = prev;
            root.left = null;

            // 4. Move prev to current
            prev = root;
        }
    }

    public static void main(String[] args) {
        // Example:
        // 1
        // / \
        // 2 5
        // / \ \
        // 3 4 6
        // Flattened: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        Solution sl = new Solution();
        sl.flatten(root);

        // Print flattened tree (Should be linked list via right pointers)
        System.out.print("Flattened Tree: ");
        Node temp = root;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.right;
        }
        System.out.println("null");
    }
}
