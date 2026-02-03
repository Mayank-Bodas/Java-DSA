package BinarySearch;

public class ShipWithinDays {
    static class Solution {
        /*
         * Pseudocode (Capacity To Ship Packages Within D Days - O(N * log(Sum-Max))):
         * Goal: Find the minimum capacity 'k' to ship all packages within 'd' days.
         * Search Space: [max(weights), sum(weights)].
         *
         * 1. Calculate range [low, high]:
         * - low = max(weights) (capacity must be at least the heaviest package).
         * - high = sum(weights) (worst case: ship all in 1 day).
         * - Done in a single pass O(N).
         * 2. Binary Search:
         * a. mid = low + (high - low) / 2.
         * b. Check if possible to ship with capacity 'mid' in <= 'd' days:
         * - Iterate through weights, accumulating load.
         * - If load + weight > mid, increment days, reset load = weight.
         * c. If daysNeeded <= d:
         * - Possible answer. Try smaller capacity: high = mid.
         * d. If daysNeeded > d:
         * - Capacity too small. Need larger: low = mid + 1.
         * 3. Return low.
         */
        public int shipWithinDays(int[] weights, int days) {
            int maxWeight = 0;
            int sumWeight = 0;
            for (int w : weights) {
                maxWeight = Math.max(maxWeight, w);
                sumWeight += w;
            }

            int low = maxWeight;
            int high = sumWeight;

            while (low < high) {
                int mid = low + (high - low) / 2;
                if (getDaysNeeded(weights, mid) <= days) {
                    high = mid; // Try smaller capacity
                } else {
                    low = mid + 1; // Increase capacity
                }
            }
            return low;
        }

        private int getDaysNeeded(int[] weights, int capacity) {
            int days = 1;
            int currentLoad = 0;
            for (int w : weights) {
                if (currentLoad + w > capacity) {
                    days++;
                    currentLoad = w;
                } else {
                    currentLoad += w;
                }
            }
            return days;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        int[] weights1 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days1 = 5;
        System.out.println("Test Case 1: " + solution.shipWithinDays(weights1, days1)); // Expected: 15

        // Test Case 2
        int[] weights2 = { 3, 2, 2, 4, 1, 4 };
        int days2 = 3;
        System.out.println("Test Case 2: " + solution.shipWithinDays(weights2, days2)); // Expected: 6

        // Test Case 3
        int[] weights3 = { 1, 2, 3, 1, 1 };
        int days3 = 4;
        System.out.println("Test Case 3: " + solution.shipWithinDays(weights3, days3)); // Expected: 3
    }
}