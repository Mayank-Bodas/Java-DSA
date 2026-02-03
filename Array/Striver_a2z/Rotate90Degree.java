package Array.Striver_a2z;

public class Rotate90Degree {
    static class Solution {
        public void rotate(int[][] matrix) {
            /*
             * Pseudocode (Optimal - In-place O(1) Space):
             * 1. Transpose the matrix:
             * - Swap matrix[i][j] with matrix[j][i] for j > i.
             * - This converts rows to columns.
             * 2. Reverse each row:
             * - For each row, swap elements from start and end moving inwards.
             * - This achieves the 90-degree clockwise rotation.
             */

            int n = matrix.length;

            // Step 1: Transpose
            for (int i = 0; i < n; i++) {
                // Iterate j from i+1 to n-1 to avoid re-swapping and handle only upper triangle
                for (int j = i + 1; j < n; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }

            // Step 2: Reverse each row
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[i][n - 1 - j];
                    matrix[i][n - 1 - j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example:
        // [1, 2, 3]
        // [4, 5, 6]
        // [7, 8, 9]
        // Rotated:
        // [7, 4, 1]
        // [8, 5, 2]
        // [9, 6, 3]

        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        Solution sl = new Solution();
        sl.rotate(matrix);

        System.out.println("Rotated Matrix:");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
