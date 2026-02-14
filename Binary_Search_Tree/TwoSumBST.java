package Binary_Search_Tree;

import java.util.HashSet;
import java.util.Set;

public class TwoSumBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Solution {
        /**
         * Checks if there exist two elements in the BST such that their sum is equal to
         * the given target.
         * 
         * Algorithm (HashSet Approach):
         * 1. Initialize a generic helper function 'find' that takes the root, target,
         * and a HashSet.
         * 2. The HashSet stores the values of the nodes visited so far.
         * 3. Base Case: If the current node is null, return false (no pair found in
         * this path).
         * 4. Check Current Node:
         * a. Calculate the complement: complement = target - node.data.
         * b. If the HashSet contains the complement, we found the pair! Return true.
         * c. Otherwise, add the current node's value to the HashSet.
         * 5. Recursive Step:
         * a. Recursively call 'find' for the left child.
         * b. Recursively call 'find' for the right child.
         * c. Return true if either the left or right subtree returns true (logical OR).
         * 
         * Time Complexity: O(N), we visit each node at most once.
         * Space Complexity: O(N), for the HashSet to store node values.
         */
        public boolean findTarget(Node root, int k) {
            Set<Integer> set = new HashSet<>();
            return find(root, k, set);
        }

        private boolean find(Node node, int k, Set<Integer> set) {
            if (node == null) {
                return false;
            }

            // Check if k - node.data exists in the set
            if (set.contains(k - node.data)) {
                return true;
            }

            // Add current node's value to the set
            set.add(node.data);

            // Recursively search in left and right subtrees
            return find(node.left, k, set) || find(node.right, k, set);
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();

        // Case 1: Pair exists (Target = 9)
        // 5
        // / \
        // 3 6
        // / \ \
        // 2 4 7
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.right = new Node(6);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right.right = new Node(7);

        int target1 = 9;
        System.out.println("Tree 1 contains pair with sum " + target1 + ": " + sl.findTarget(root1, target1)); // Expected:
                                                                                                               // true
                                                                                                               // (e.g.,
                                                                                                               // 5 + 4,
                                                                                                               // 2 + 7,
                                                                                                               // 3 + 6)

        // Case 2: Pair does not exist (Target = 28)
        int target2 = 28;
        System.out.println("Tree 1 contains pair with sum " + target2 + ": " + sl.findTarget(root1, target2)); // Expected:
                                                                                                               // false

        // Case 3: Single Node (Target = 10)
        Node root2 = new Node(5);
        int target3 = 10;
        System.out.println("Tree 2 contains pair with sum " + target3 + ": " + sl.findTarget(root2, target3)); // Expected:
                                                                                                               // false
    }
}
