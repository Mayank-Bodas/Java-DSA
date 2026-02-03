package BinarySearch;

public class FindSqrt {
    static class Solution {
        public int mySqrt(int x) {
            /*
             * Pseudocode (Square Root - O(log N)):
             * 1. Handle edge cases: If x < 2, return x.
             * 2. Initialize left = 1, right = x/2 (since sqrt(x) <= x/2 for x>=4).
             * 3. Loop while left <= right:
             * a. mid = left + (right - left) / 2.
             * b. If mid * mid <= x:
             * - This 'mid' is a candidate. Store ans = mid.
             * - Search right for a larger candidate: left = mid + 1.
             * c. Else (mid * mid > x):
             * - 'mid' is too large. Search left: right = mid - 1.
             * 4. Return ans.
             * 
             * Note: Use 'long' for 'mid*mid' to prevent integer overflow.
             */

            if (x < 2)
                return x;

            int left = 1, right = x / 2, ans = 0;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                long square = mid * mid;

                if (square == x)
                    return (int) mid;

                if (square < x) {
                    ans = (int) mid;
                    left = (int) mid + 1;
                } else {
                    right = (int) mid - 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        // Example: Sqrt(4) = 2
        // Example: Sqrt(8) = 2 (2.828 rounded down)

        Solution sl = new Solution();

        System.out.println("Sqrt(4): " + sl.mySqrt(4));
        System.out.println("Sqrt(8): " + sl.mySqrt(8));
        System.out.println("Sqrt(0): " + sl.mySqrt(0));
        System.out.println("Sqrt(2147395599): " + sl.mySqrt(2147395599)); // Max int boundary check
    }
}
