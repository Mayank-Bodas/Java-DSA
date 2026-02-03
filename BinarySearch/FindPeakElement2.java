package BinarySearch;

import java.util.Arrays;

public class FindPeakElement2 {
    static class Solution {
        /*
         * Pseudocode (Find a Peak Element II - O(N * log(M))):
         * Goal: Find indices (row, col) of a peak element in a 2D matrix.
         * A peak is strictly greater than its top, bottom, left, and right neighbors.
         * 
         * Approach: Binary Search on Columns.
         * 
         * 1. Initialize 'startCol' = 0, 'endCol' = m - 1.
         * 2. Loop while startCol <= endCol:
         * a. midCol = (startCol + endCol) / 2.
         * b. Find the row index 'maxRow' of the maximum element in 'midCol'.
         * (This guarantees it's a peak relative to top and bottom neighbors in that
         * column).
         * c. Compare matrix[maxRow][midCol] with its left and right neighbors:
         * - neighborLeft = (midCol > 0) ? matrix[maxRow][midCol - 1] : -1 (essentially
         * -infinity).
         * - neighborRight = (midCol < m - 1) ? matrix[maxRow][midCol + 1] : -1.
         * d. Evaluation:
         * - If matrix[maxRow][midCol] > neighborLeft AND > neighborRight:
         * Found a peak! Return {maxRow, midCol}.
         * - If matrix[maxRow][midCol] < neighborLeft:
         * Peak must be to the left. endCol = midCol - 1.
         * - Else (implied matrix[maxRow][midCol] < neighborRight):
         * Peak must be to the right. startCol = midCol + 1.
         * 3. Return {-1, -1} (should not be reached given problem constraints).
         */
        public int[] findPeakGrid(int[][] mat) {
            int n = mat.length;
            int m = mat[0].length;

            int startCol = 0;
            int endCol = m - 1;

            while (startCol <= endCol) {
                int midCol = startCol + (endCol - startCol) / 2;

                // Find global max in this column
                int maxRow = 0;
                for (int row = 0; row < n; row++) {
                    if (mat[row][midCol] > mat[maxRow][midCol]) {
                        maxRow = row;
                    }
                }

                int currElement = mat[maxRow][midCol];
                int leftElement = (midCol > 0) ? mat[maxRow][midCol - 1] : -1;
                int rightElement = (midCol < m - 1) ? mat[maxRow][midCol + 1] : -1;

                if (currElement > leftElement && currElement > rightElement) {
                    return new int[] { maxRow, midCol };
                } else if (currElement < leftElement) {
                    endCol = midCol - 1;
                } else {
                    startCol = midCol + 1;
                }
            }

            return new int[] { -1, -1 };
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[][] mat1 = { { 1, 4 }, { 3, 2 } };
        System.out.println("Test Case 1: " + Arrays.toString(solution.findPeakGrid(mat1)));
        // Expected: [0, 1] (4 is a peak) or [1, 0] (3 is a peak)

        // Test Case 2
        int[][] mat2 = { { 10, 20, 15 }, { 21, 30, 14 }, { 7, 16, 32 } };
        System.out.println("Test Case 2: " + Arrays.toString(solution.findPeakGrid(mat2)));
        // Expected: [1, 1] (30 is a peak) or [2, 2] (32 is a peak)

        // Test Case 3 (Single element)
        int[][] mat3 = { { 1 } };
        System.out.println("Test Case 3: " + Arrays.toString(solution.findPeakGrid(mat3)));
        // Expected: [0, 0]
    }
}
