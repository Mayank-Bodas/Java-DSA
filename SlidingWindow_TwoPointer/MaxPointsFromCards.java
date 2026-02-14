package SlidingWindow_TwoPointer;

public class MaxPointsFromCards {
    static class Solution {
        public int maxScore(int[] cardPoints, int k) {
            /*
             * Pseudocode (Maximum Points You Can Obtain from Cards - O(K)):
             * Goal: Pick k cards from either end to maximize score.
             * Logic:
             * Maximum sum of k cards picked from ends = Total Sum - Minimum subarray sum of
             * length (n-k).
             * Alternatively (Sliding Window):
             * 1. Start with sum of first 'k' cards (all from left). Store as maxScore.
             * 2. Iterate i from 0 to k-1:
             * a. Remove cardPoints[k-1-i] (rightmost card of left set).
             * b. Add cardPoints[n-1-i] (current card from right end).
             * c. Update maxScore = max(maxScore, currentSum).
             * 3. Return maxScore.
             */

            int n = cardPoints.length;
            int currentSum = 0;

            // Initial sum: first k elements
            for (int i = 0; i < k; i++) {
                currentSum += cardPoints[i];
            }

            int maxScore = currentSum;

            // Slide window: remove from left (k-1 down to 0), add from right (n-1 down to
            // n-k)
            for (int i = 0; i < k; i++) {
                currentSum = currentSum - cardPoints[k - 1 - i] + cardPoints[n - 1 - i];
                maxScore = Math.max(maxScore, currentSum);
            }

            return maxScore;
        }
    }

    public static void main(String[] args) {
        // Example 1: [1,2,3,4,5,6,1], k=3 -> 12 (1+6+5)
        int[] cards1 = { 1, 2, 3, 4, 5, 6, 1 };
        int k1 = 3;
        Solution sl = new Solution();
        System.out.println("Cards: [1,2,3,4,5,6,1], K: 3 -> " + sl.maxScore(cards1, k1));

        // Example 2: [2,2,2], k=2 -> 4
        int[] cards2 = { 2, 2, 2 };
        int k2 = 2;
        System.out.println("Cards: [2,2,2], K: 2 -> " + sl.maxScore(cards2, k2));

        // Example 3: [9,7,7,9,7,7,9], k=7 -> 55 (All)
        int[] cards3 = { 9, 7, 7, 9, 7, 7, 9 };
        int k3 = 7;
        System.out.println("Cards: [9,7,7,9,7,7,9], K: 7 -> " + sl.maxScore(cards3, k3));
    }
}
