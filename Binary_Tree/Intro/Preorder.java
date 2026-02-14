package Binary_Tree.Intro;

import java.util.ArrayList;
import java.util.List;

public class Preorder {
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
         * Pseudocode (Preorder Traversal - Recursive):
         * 1. If root is null, return.
         * 2. Process root (Visit/Add to list).
         * 3. Recurse Left.
         * 4. Recurse Right.
         */
        public List<Integer> preorderTraversal(Node root) {
            List<Integer> result = new ArrayList<>();
            preorderHelper(root, result);
            return result;
        }

        private void preorderHelper(Node node, List<Integer> result) {
            if (node == null) {
                return;
            }
            result.add(node.data);
            preorderHelper(node.left, result);
            preorderHelper(node.right, result);
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
        List<Integer> result = sl.preorderTraversal(root);

        System.out.print("Preorder Traversal: " + result);
        // Expected: [1, 2, 4, 5, 3]
    }
}
