package Binary_Tree.Questions;

import java.util.ArrayList;
import java.util.List;

public class PrintRootToNode {
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
         * Pseudocode (Path from Root to Node - O(N)):
         * 1. If root is null, return false.
         * 2. Add root.data to path list.
         * 3. If root.data == target x, return true (found).
         * 4. Recursively check Left and Right subtrees.
         * a. If either returns true, return true.
         * 5. If not found in either child, Backtrack: remove last element from path.
         * 6. Return false.
         */
        public List<Integer> solve(Node root, int x) {
            List<Integer> arr = new ArrayList<>();
            if (root == null)
                return arr;
            getPath(root, arr, x);
            return arr;
        }

        private boolean getPath(Node root, List<Integer> arr, int x) {
            if (root == null)
                return false;

            arr.add(root.data);

            // If found target
            if (root.data == x)
                return true;

            // Search Left or Right
            if (getPath(root.left, arr, x) || getPath(root.right, arr, x))
                return true;

            // Backtrack: Remove current node from path if not found in subtree
            arr.remove(arr.size() - 1);
            return false;
        }
    }

    public static void main(String[] args) {
        // Example:
        // 1
        // / \
        // 2 3
        // / \ / \
        // 4 5 6 7
        // Path to 5: [1, 2, 5]
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Solution sl = new Solution();
        int target = 5;
        List<Integer> path = sl.solve(root, target);
        System.out.println("Path to " + target + ": " + path); // [1, 2, 5]

        target = 7;
        path = sl.solve(root, target);
        System.out.println("Path to " + target + ": " + path); // [1, 3, 7]
    }
}
