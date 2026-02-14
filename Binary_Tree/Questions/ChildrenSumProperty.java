package Binary_Tree.Questions;

public class ChildrenSumProperty {
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
         * Pseudocode (Children Sum Property Check - O(N)):
         * 1. If root is null or a leaf node, return true (Base case).
         * 2. Calculate sum of left and right children values.
         * 3. If root.data != sum, return false.
         * 4. Recursively check left and right subtrees.
         * 5. Return (checkLeft && checkRight).
         */
        public boolean isChildrenSumProperty(Node root) {
            // Base case: null or leaf node satisfies property
            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }

            int sum = 0;
            if (root.left != null) {
                sum += root.left.data;
            }
            if (root.right != null) {
                sum += root.right.data;
            }

            // Check check current node property
            if (root.data != sum) {
                return false;
            }

            // Recursive check for children
            return isChildrenSumProperty(root.left) && isChildrenSumProperty(root.right);
        }
    }

    public static void main(String[] args) {
        // Example 1: Satisfies Property
        // 10
        // / \
        // 8 2
        // / \ \
        // 3 5 2
        Node root = new Node(10);
        root.left = new Node(8);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.right = new Node(2);

        Solution sl = new Solution();
        System.out.println("Satisfies Children Sum Property? " + sl.isChildrenSumProperty(root)); // true

        // Example 2: Fails
        // 10
        // / \
        // 5 2
        Node root2 = new Node(10);
        root2.left = new Node(5);
        root2.right = new Node(2);

        System.out.println("Satisfies Children Sum Property 2? " + sl.isChildrenSumProperty(root2)); // false (5+2 = 7
                                                                                                     // != 10)
    }
}
