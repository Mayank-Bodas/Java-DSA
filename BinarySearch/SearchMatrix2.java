package BinarySearch;

public class SearchMatrix2 {
    static class Solution {
        /*
         * Pseudocode (Search a 2D Matrix II - O(N + M)):
         * Goal: Search for a target in a matrix where rows are sorted left-to-right
         * and columns are sorted top-to-bottom.
         * Concept: Start from the top-right corner.
         * 
         * 1. Check edge cases: if matrix is empty, return false.
         * 2. Initialize pointers:
         * - row = 0 (top row)
         * - col = m - 1 (last column)
         * 3. Loop while row < n and col >= 0:
         * a. If matrix[row][col] == target: Return true.
         * b. If matrix[row][col] < target:
         * - Current element is smaller than target.
         * - Since row is sorted, we need larger values -> Move down (row++).
         * c. If matrix[row][col] > target:
         * - Current element is larger than target.
         * - Since col is sorted, we need smaller values -> Move left (col--).
         * 4. Return false if loop finishes (target not found).
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int n = matrix.length;
            int m = matrix[0].length;
            int row = 0;
            int col = m - 1;

            while (row < n && col >= 0) {
                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] < target) {
                    row++;
                } else {
                    col--;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Target exists
        int[][] matrix1 = {
                { 1, 4, 7, 11, 15 },
                { 2, 5, 8, 12, 19 },
                { 3, 6, 9, 16, 22 },
                { 10, 13, 14, 17, 24 },
                { 18, 21, 23, 26, 30 }
        };
        int target1 = 5;
        System.out.println("Test Case 1: " + solution.searchMatrix(matrix1, target1)); // Expected: true

        // Test Case 2: Target does not exist
        int target2 = 20;
        System.out.println("Test Case 2: " + solution.searchMatrix(matrix1, target2)); // Expected: false

        // Test Case 3: Empty matrix
        int[][] matrix3 = {};
        System.out.println("Test Case 3: " + solution.searchMatrix(matrix3, 1)); // Expected: false
    }
}
