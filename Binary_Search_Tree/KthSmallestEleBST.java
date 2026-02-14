package Binary_Search_Tree;

import java.util.Stack;

public class KthSmallestEleBST {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }

    static class Solution {
        /**
         * Kth Smallest Element in a BST
         * 
         * Algorithm (Iterative Inorder Traversal):
         * 1. Initialize a Stack to keep track of nodes.
         * 2. Traverse left:
         * a. While the current node is not null, push it to the stack and move to its
         * left child.
         * 3. Process the node:
         * a. Pop the top node from the stack.
         * b. Decrement 'k'.
         * c. If 'k' becomes 0, the popped node is the Kth smallest element. Return its
         * value.
         * 4. Move to the right child:
         * a. Set current node to the right child of the popped node.
         * 5. Repeat steps 2-4 until the stack is empty and the current node is null.
         * 
         * Time Complexity: O(H + k), where H is the height of the tree.
         * Space Complexity: O(H) for the stack.
         */
        public int kthSmallest(Node root, int k) {
            Stack<Node> stack = new Stack<>();
            Node current = root;

            while (current != null || !stack.isEmpty()) {
                // Reach the leftmost node of the current subtree
                while (current != null) {
                    stack.push(current);
                    current = current.left;
                }

                // Current must be null at this point
                current = stack.pop();

                // Decrement k
                k--;

                // If k becomes 0, we found the kth smallest element
                if (k == 0) {
                    return current.data;
                }

                // Visit the right subtree
                current = current.right;
            }

            return -1; // Should not be reached if k is valid
        }
    }

    public static void main(String[] args) {
        // Constructing BST
        // 5
        // / \
        // 3 6
        // / \
        // 2 4
        // /
        // 1

        Node root = new Node(5);
        root.left = new Node(3);
        root.right = new Node(6);
        root.left.left = new Node(2);
        root.left.right = new Node(4);
        root.left.left.left = new Node(1);

        Solution sl = new Solution();

        // Test cases
        int k = 1;
        System.out.println("Kth smallest element (k=" + k + "): " + sl.kthSmallest(root, k)); // Expected: 1

        k = 3;
        System.out.println("Kth smallest element (k=" + k + "): " + sl.kthSmallest(root, k)); // Expected: 3

        k = 4;
        System.out.println("Kth smallest element (k=" + k + "): " + sl.kthSmallest(root, k)); // Expected: 4

        k = 6;
        System.out.println("Kth smallest element (k=" + k + "): " + sl.kthSmallest(root, k)); // Expected: 6
    }
}
