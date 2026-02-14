package Binary_Tree.Questions;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {
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
         * Pseudocode (Boundary Traversal - O(N)):
         * 1. Add root to result (if not leaf).
         * 2. Traverse Left Boundary (excluding leaves):
         * a. Move left if exists, else move right.
         * b. If leaf, stop.
         * c. Add to result.
         * 3. Traverse Leaves (DFS - Inorder/Preorder):
         * a. If leaf, add to result.
         * 4. Traverse Right Boundary (reverse order, excluding leaves):
         * a. Move right if exists, else move left.
         * b. If leaf, stop.
         * c. Push to stack/temp list.
         * d. Add from stack to result (reverse).
         */
        public List<Integer> boundaryTraversal(Node root) {
            List<Integer> result = new ArrayList<>();
            if (root == null)
                return result;

            // 1. Add root (unless it's a leaf, handled inside standard logic or separately)
            // Convention: Root is always part of boundary.
            if (!isLeaf(root)) {
                result.add(root.data);
            }

            // 2. Add Left Boundary
            addLeftBoundary(root.left, result);

            // 3. Add Leaves
            addLeaves(root, result);

            // 4. Add Right Boundary (Reverse)
            addRightBoundary(root.right, result);

            return result;
        }

        private boolean isLeaf(Node node) {
            return node != null && node.left == null && node.right == null;
        }

        private void addLeftBoundary(Node node, List<Integer> result) {
            Node cur = node;
            while (cur != null) {
                if (!isLeaf(cur)) {
                    result.add(cur.data);
                }
                if (cur.left != null) {
                    cur = cur.left;
                } else {
                    cur = cur.right; // Go right if left is missing
                }
            }
        }

        private void addLeaves(Node node, List<Integer> result) {
            if (node == null)
                return;
            if (isLeaf(node)) {
                result.add(node.data);
                return;
            }
            addLeaves(node.left, result);
            addLeaves(node.right, result);
        }

        private void addRightBoundary(Node node, List<Integer> result) {
            Node cur = node;
            List<Integer> temp = new ArrayList<>();
            while (cur != null) {
                if (!isLeaf(cur)) {
                    temp.add(cur.data);
                }
                if (cur.right != null) {
                    cur = cur.right;
                } else {
                    cur = cur.left; // Go left if right is missing
                }
            }
            // Add right boundary in reverse
            for (int i = temp.size() - 1; i >= 0; i--) {
                result.add(temp.get(i));
            }
        }
    }

    public static void main(String[] args) {
        // Example:
        // 1
        // / \
        // 2 3
        // / \ / \
        // 4 5 6 7
        // Boundary: 1 -> 2 -> 4 -> 5 -> 6 -> 7 -> 3
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Solution sl = new Solution();
        List<Integer> boundary = sl.boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + boundary);
        // Output: [1, 2, 4, 5, 6, 7, 3]

        // Example 2 (Complex - Left missing child):
        // 1
        // \
        // 2
        // /
        // 3
        // Boundary: 1 -> 3 -> 2
        Node root2 = new Node(1);
        root2.right = new Node(2);
        root2.right.left = new Node(3);

        System.out.println("Boundary Traversal 2: " + sl.boundaryTraversal(root2));
        // Logic:
        // Root: 1
        // Left: (root.left is null) -> nothing
        // Leaves: 3
        // Right: (root.right is 2). 2 is not leaf. 2 -> (child 3, taken by leaves).
        // Wait. addRightBoundary(root.right):
        // cur=2. !isLeaf(2). Add 2 to temp.
        // cur.right (null) -> cur=cur.left (3).
        // cur=3. isLeaf(3) -> No add.
        // Return [2] reversed -> [2].
        // Total: 1, 3, 2. Correct.
    }
}
