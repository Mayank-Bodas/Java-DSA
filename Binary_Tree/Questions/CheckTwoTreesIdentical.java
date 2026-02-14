package Binary_Tree.Questions;

public class CheckTwoTreesIdentical {
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
         * Pseudocode (Check if Two Trees are Identical - O(N)):
         * 1. If both p and q are null, return true.
         * 2. If one is null (and other isn't), return false.
         * 3. Check if current data matches.
         * 4. Recursively check left subtrees AND right subtrees.
         * 5. Return (dataMatch && leftMatch && rightMatch).
         */
        public boolean isIdentical(Node node1, Node node2) {
            // Both are null -> Identical
            if (node1 == null && node2 == null) {
                return true;
            }

            // One is null, other is not -> Not Identical
            if (node1 == null || node2 == null) {
                return false;
            }

            // Data match and recursive checks
            return (node1.data == node2.data) &&
                    isIdentical(node1.left, node2.left) &&
                    isIdentical(node1.right, node2.right);
        }
    }

    public static void main(String[] args) {
        // Example 1: Identical Trees
        // 1 1
        // / \ / \
        // 2 3 2 3
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        Solution sl = new Solution();
        System.out.println("Are trees identical? " + sl.isIdentical(root1, root2)); // true

        // Example 2: Different Structure
        // 1 1
        // / \
        // 2 2
        Node root3 = new Node(1);
        root3.left = new Node(2);

        Node root4 = new Node(1);
        root4.right = new Node(2);

        System.out.println("Are trees identical? " + sl.isIdentical(root3, root4)); // false
    }
}
