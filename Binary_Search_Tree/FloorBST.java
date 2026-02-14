package Binary_Search_Tree;

public class FloorBST {
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
         * Pseudocode (Floor in BST - O(H)):
         * Goal: Find largest value <= key.
         * 1. Initialize floor = -1.
         * 2. Loop while root is not null:
         * a. If root.data == key, floor = root.data, return.
         * b. If key > root.data:
         * - root is a candidate floor (smaller than key).
         * - Update floor = root.data.
         * - Move right to find larger value <= key.
         * c. If key < root.data:
         * - root is too large.
         * - Move left.
         * 3. Return floor.
         */
        public int floorInBST(Node root, int key) {
            int floor = -1;
            while (root != null) {
                if (root.data == key) {
                    return root.data;
                }

                if (key > root.data) {
                    // Current root value is smaller than key -> Potential Floor
                    floor = root.data;
                    root = root.right; // Try to find a larger value that is still <= key
                } else {
                    // Current root value is larger than key -> Not a floor candidate
                    root = root.left;
                }
            }
            return floor;
        }
    }

    public static void main(String[] args) {
        // Constructing BST
        // 8
        // / \
        // 5 10
        // / \ \
        // 2 6 12
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        root.right.right = new Node(12);

        Solution sl = new Solution();
        int key = 9;
        System.out.println("Floor of " + key + ": " + sl.floorInBST(root, key)); // Output: 8

        key = 6;
        System.out.println("Floor of " + key + ": " + sl.floorInBST(root, key)); // Output: 6

        key = 1;
        System.out.println("Floor of " + key + ": " + sl.floorInBST(root, key)); // Output: -1
    }
}
