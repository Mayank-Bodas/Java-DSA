package BinarySearch;

public class NthRootOfM {
    static class Solution {
        public int nthRoot(int n, int m) {
            /*
             * Pseudocode (Nth Root of M - O(log M * log N)):
             * Calculate integer nth root. If exact root exists, return it, else -1.
             * 
             * 1. Initialize low = 1, high = m.
             * 2. Loop while low <= high:
             * a. mid = (low + high) / 2.
             * b. Check `mid^n`:
             * - Use helper func(mid, n, m) to handle overflow:
             * - Returns 1 if mid^n == m
             * - Returns 2 if mid^n > m
             * - Returns 0 if mid^n < m
             * c. If mid^n == m: return mid.
             * d. If mid^n < m: low = mid + 1.
             * e. If mid^n > m: high = mid - 1.
             * 3. Return -1.
             */

            int low = 1, high = m;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                int val = func(mid, n, m);

                if (val == 1) {
                    return mid;
                } else if (val == 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            return -1;
        }

        // Helper to check power value safely
        // Return 1 if == m, 2 if > m, 0 if < m
        private int func(int mid, int n, int m) {
            long ans = 1;
            for (int i = 1; i <= n; i++) {
                ans = ans * mid;
                if (ans > m)
                    return 2;
            }
            if (ans == m)
                return 1;
            return 0;
        }
    }

    public static void main(String[] args) {
        // Example 1: N=3, M=27 -> Root is 3
        int n = 3, m = 27;
        Solution sl = new Solution();

        System.out.println("N: 3, M: 27 -> Nth Root: " + sl.nthRoot(n, m));
        System.out.println("N: 4, M: 69 -> Nth Root: " + sl.nthRoot(4, 69)); // No perfect root -> -1
        System.out.println("N: 9, M: 1953125 -> Nth Root: " + sl.nthRoot(9, 1953125)); // 5^9 = 1953125
    }
}
