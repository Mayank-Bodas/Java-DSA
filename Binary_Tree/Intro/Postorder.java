package Binary_Tree.Intro;

import java.util.ArrayList;
import java.util.List;

public class Postorder {
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
         * Pseudocode (Postorder Traversal - Recursive):
         * 1. If root is null, return.
         * 2. Recurse Left.
         * 3. Recurse Right.
         * 4. Process root.
         */
        public List<Integer> postorderTraversal(Node root) {
            List<Integer> list = new ArrayList<>();
            postorder(root, list);
            return list;
        }

        private void postorder(Node root, List<Integer> list) {
            if (root == null)
                return;

            postorder(root.left, list);
            postorder(root.right, list);
            list.add(root.data);
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
        List<Integer> result = sl.postorderTraversal(root);

        System.out.println("Postorder Traversal: " + result);
        // Expected: [4, 5, 2, 3, 1]
    }
}
