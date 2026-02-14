package Binary_Tree.Intro;

import java.util.ArrayList;
import java.util.List;

public class Inorder {
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
         * Pseudocode (Inorder Traversal - Recursive):
         * 1. If root is null, return.
         * 2. Recurse Left.
         * 3. Process root.
         * 4. Recurse Right.
         */
        public List<Integer> inorderTraversal(Node root) {
            List<Integer> list = new ArrayList<>();
            inorder(root, list);
            return list;
        }

        private void inorder(Node root, List<Integer> list) {
            if (root == null)
                return;
            inorder(root.left, list);
            list.add(root.data);
            inorder(root.right, list);
        }
    }

    public static void main(String[] args) {
        // Creating a simple tree:
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
        List<Integer> result = sl.inorderTraversal(root);

        System.out.println("Inorder Traversal: " + result);
        // Expected: [4, 2, 5, 1, 3]
    }
}
