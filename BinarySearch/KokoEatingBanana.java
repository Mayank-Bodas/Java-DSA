package BinarySearch;

import java.util.Arrays;

public class KokoEatingBanana {
    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            /*
             * Pseudocode (Koko Eating Bananas - O(N * log(MaxPile))):
             * Goal: Find min 'k' such that total hours <= h.
             * Range for 'k': [1, max(piles)].
             * 
             * 1. Initialize low = 1, high = max(piles).
             * 2. Loop while low <= high:
             * a. mid = (low + high) / 2.
             * b. Calculate 'requiredHours' (inline loop):
             * - Iterate through piles.
             * - Add ceil(pile / mid) to hours.
             * - Efficient ceil: (pile + mid - 1) / mid.
             * c. If requiredHours <= h:
             * - Valid speed. Store ans = mid.
             * - Try smaller: high = mid - 1.
             * d. Else (requiredHours > h):
             * - Too slow. Need higher speed: low = mid + 1.
             * 3. Return 'ans'.
             * 
             * Note: Use 'long' for hours to prevent overflow.
             */

            int maxPile = 0;
            for (int pile : piles) {
                if (pile > maxPile) {
                    maxPile = pile;
                }
            }

            int low = 1, high = maxPile;
            int ans = maxPile;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                long requiredHours = 0;
                for (int pile : piles) {
                    requiredHours += (pile + mid - 1) / mid;
                }

                if (requiredHours <= h) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        // Example 1: piles = [3,6,7,11], h = 8 -> Output: 4
        int[] piles1 = { 3, 6, 7, 11 };
        int h1 = 8;
        Solution sl = new Solution();
        System.out.println(
                "Piles: " + Arrays.toString(piles1) + ", H: " + h1 + " -> K: " + sl.minEatingSpeed(piles1, h1));

        // Example 2: piles = [30,11,23,4,20], h = 5 -> Output: 30
        int[] piles2 = { 30, 11, 23, 4, 20 };
        int h2 = 5;
        System.out.println(
                "Piles: " + Arrays.toString(piles2) + ", H: " + h2 + " -> K: " + sl.minEatingSpeed(piles2, h2));

        // Example 3: piles = [30,11,23,4,20], h = 6 -> Output: 23
        int h3 = 6;
        System.out.println(
                "Piles: " + Arrays.toString(piles2) + ", H: " + h3 + " -> K: " + sl.minEatingSpeed(piles2, h3));
    }
}
