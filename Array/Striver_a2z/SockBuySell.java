package Array.Striver_a2z;

public class SockBuySell {
    static class Solution {
        public int maxProfit(int[] prices) {
            /*
             * Pseudocode (Optimal - O(N)):
             * 1. Initialize 'mini' (minimum buy price) with the first element prices[0].
             * 2. Initialize 'profit' (maximum profit) as 0.
             * 3. Traverse the array from index 0 to n-1:
             * a. If prices[i] < mini:
             * - Update 'mini' = prices[i].
             * b. Else:
             * - Calculate current potential profit = prices[i] - mini.
             * - Update 'profit' = max(profit, prices[i] - mini).
             * 4. Return 'profit'.
             */

            int mini = prices[0];
            int profit = 0;

            for (int i = 0; i < prices.length; i++) {
                int cost = prices[i] - mini;

                profit = Math.max(profit, cost);

                mini = Math.min(mini, prices[i]);
            }
            return profit;
        }
    }

    public static void main(String[] args) {
        // Example: [7, 1, 5, 3, 6, 4]
        // Buy at 1 (day 2), Sell at 6 (day 5), Profit = 5.
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        System.out.print("Prices: ");
        for (int p : prices)
            System.out.print(p + " ");
        System.out.println();

        Solution sl = new Solution();
        int maxProfit = sl.maxProfit(prices);

        System.out.println("Max Profit: " + maxProfit);

        // Example 2: [7, 6, 4, 3, 1] -> Profit 0
        int[] prices2 = { 7, 6, 4, 3, 1 };
        System.out.println("Max Profit for descending prices: " + sl.maxProfit(prices2));
    }
}
