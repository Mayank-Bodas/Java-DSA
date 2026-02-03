package Array.Striver_a2z;

public class SetZeroes {
    static class Solution {
        public void setZeroes(int[][] matrix) {
            /*
             * Pseudocode (Optimal - O(1) Space):
             * 1. Use the first row (matrix[0][..]) and first column (matrix[..][0]) as
             * markers.
             * - matrix[i][0] marks if row 'i' needs to be zero.
             * - matrix[0][j] marks if col 'j' needs to be zero.
             * 2. Since matrix[0][0] overlaps, use a separate variable 'col0' for the first
             * column's state.
             * 3. Traverse the matrix (0 to n-1, 0 to m-1):
             * a. If matrix[i][j] is 0:
             * - Set matrix[i][0] = 0 (mark row).
             * - If j != 0, set matrix[0][j] = 0 (mark col).
             * - If j == 0, set col0 = 0.
             * 4. Iterate from (1 to n-1, 1 to m-1):
             * - If matrix[i][0] == 0 or matrix[0][j] == 0, set matrix[i][j] = 0.
             * 5. Handle first row: If matrix[0][0] == 0, set entire first row to 0.
             * 6. Handle first col: If col0 == 0, set entire first col to 0.
             */

            int n = matrix.length;
            int m = matrix[0].length;
            int col0 = 1; // Flag for the first column

            // Step 1: Mark rows and columns in-place
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == 0) {
                        // Mark the i-th row
                        matrix[i][0] = 0;

                        // Mark the j-th column
                        if (j != 0) {
                            matrix[0][j] = 0;
                        } else {
                            col0 = 0; // Special case for the first column
                        }
                    }
                }
            }

            // Step 2: Set zeros for submatrix (1..n-1, 1..m-1)
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }

            // Step 3: Handle the first row
            if (matrix[0][0] == 0) {
                for (int j = 0; j < m; j++) {
                    matrix[0][j] = 0;
                }
            }

            // Step 4: Handle the first column
            if (col0 == 0) {
                for (int i = 0; i < n; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Example:
        // [1, 1, 1]
        // [1, 0, 1]
        // [1, 1, 1]
        // Output:
        // [1, 0, 1]
        // [0, 0, 0]
        // [1, 0, 1]

        int[][] matrix = {
                { 1, 1, 1 },
                { 1, 0, 1 },
                { 1, 1, 1 }
        };

        System.out.println("Original Matrix:");
        printMatrix(matrix);

        Solution sl = new Solution();
        sl.setZeroes(matrix);

        System.out.println("Modified Matrix:");
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
