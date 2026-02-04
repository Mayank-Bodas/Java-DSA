package Array.Striver_a2z;

import java.util.ArrayList;
import java.util.List;

public class SpriralMatrix {
    static class Solution {
        /*
         * Pseudocode (Spiral Matrix - O(N*M)):
         * Goal: Return all elements of the matrix in spiral order.
         * 
         * 1. Initialize boundaries: top, bottom, left, right.
         * 2. Loop while top <= bottom and left <= right:
         * a. Traverse Top Row (left to right). Increment top.
         * b. Traverse Right Col (top to bottom). Decrement right.
         * c. Traverse Bottom Row (right to left):
         * - Check if (top <= bottom) to avoid duplicate row traversal.
         * - Decrement bottom.
         * d. Traverse Left Col (bottom to top):
         * - Check if (left <= right) to avoid duplicate col traversal.
         * - Increment left.
         * 3. Return result list.
         */
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<>();
            if (matrix == null || matrix.length == 0)
                return res;

            int top = 0;
            int bottom = matrix.length - 1;
            int left = 0;
            int right = matrix[0].length - 1;

            while (top <= bottom && left <= right) {
                // Left -> Right
                for (int i = left; i <= right; i++) {
                    res.add(matrix[top][i]);
                }
                top++;

                // Top -> Bottom
                for (int i = top; i <= bottom; i++) {
                    res.add(matrix[i][right]);
                }
                right--;

                // Right -> Left
                if (top <= bottom) {
                    for (int i = right; i >= left; i--) { // Fixed: i-- instead of i++
                        res.add(matrix[bottom][i]);
                    }
                    bottom--;
                }

                // Bottom -> Top
                if (left <= right) {
                    for (int i = bottom; i >= top; i--) {
                        res.add(matrix[i][left]);
                    }
                    left++;
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: 3x3 matrix
        int[][] mat1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println("Test Case 1: " + solution.spiralOrder(mat1));
        // Expected: [1, 2, 3, 6, 9, 8, 7, 4, 5]

        // Test Case 2: 3x4 matrix
        int[][] mat2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
        System.out.println("Test Case 2: " + solution.spiralOrder(mat2));
        // Expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]

        // Test Case 3: Empty Matrix
        int[][] mat3 = {};
        System.out.println("Test Case 3: " + solution.spiralOrder(mat3));
        // Expected: []
    }
}
