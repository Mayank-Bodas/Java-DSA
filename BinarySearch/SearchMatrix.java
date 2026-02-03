package BinarySearch;

public class SearchMatrix {
    static class Solution {
        /*
         * Pseudocode (Search a 2D Matrix - O(log(N*M))):
         * Goal: Check if 'target' exists in a row-wise sorted matrix where last element
         * of row i < first element of row i+1.
         * Concept: Treat the 2D matrix (N x M) as a flattened 1D sorted array of size
         * N*M.
         * 
         * 1. Check edge cases: if matrix is empty, return false.
         * 2. Initialize binary search range:
         * - low = 0
         * - high = (n * m) - 1
         * 3. Binary Search:
         * a. mid = low + (high - low) / 2.
         * b. Map 'mid' index back to 2D coordinates:
         * - row = mid / m
         * - col = mid % m
         * c. Compare matrix[row][col] with target:
         * - If equal: Return true.
         * - If < target: low = mid + 1.
         * - If > target: high = mid - 1.
         * 4. Return false if loop finishes.
         */
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return false;
            }

            int n = matrix.length;
            int m = matrix[0].length;
            int low = 0;
            int high = n * m - 1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int row = mid / m;
                int col = mid % m;

                if (matrix[row][col] == target) {
                    return true;
                } else if (matrix[row][col] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Target exists
        int[][] matrix1 = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 60 }
        };
        int target1 = 3;
        System.out.println("Test Case 1: " + solution.searchMatrix(matrix1, target1)); // Expected: true

        // Test Case 2: Target does not exist
        int target2 = 13;
        System.out.println("Test Case 2: " + solution.searchMatrix(matrix1, target2)); // Expected: false

        // Test Case 3: Empty matrix
        int[][] matrix3 = {};
        System.out.println("Test Case 3: " + solution.searchMatrix(matrix3, 1)); // Expected: false
    }
}
