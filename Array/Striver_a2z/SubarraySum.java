package Array.Striver_a2z;

import java.util.HashMap;

public class SubarraySum {
    static class Solution {
        public int subarraySum(int[] nums, int k) {
            /*
             * Pseudocode (Optimal - O(N)):
             * 1. Initialize 'count' = 0 and 'sum' = 0.
             * 2. Use a HashMap to store the frequency of prefix sums.
             * Put {0 -> 1} initially (to handle subarrays starting from index 0).
             * 3. Traverse the array:
             * a. Add current element to 'sum'.
             * b. Check if (sum - k) exists in the map.
             * c. If yes, add its frequency to 'count'.
             * d. Update the map with the current 'sum' (increment frequency).
             * 4. Return 'count'.
             */

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1); // Base case

            int sum = 0;
            int count = 0;

            for (int num : nums) {
                sum += num;

                // If (sum - k) exists in map, add its frequency to count
                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }

                // Update map with current prefix sum
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();

        // Example 1: [1, 1, 1], k = 2
        int[] arr1 = { 1, 1, 1 };
        int k1 = 2;
        System.out.println("Test Case 1: [1,1,1], k=2 -> Count: " + sl.subarraySum(arr1, k1));

        // Example 2: [1, 2, 3], k = 3
        int[] arr2 = { 1, 2, 3 };
        int k2 = 3;
        System.out.println("Test Case 2: [1,2,3], k=3 -> Count: " + sl.subarraySum(arr2, k2));

        // Example 3: [1, 2, 1, 2, 1], k = 3
        int[] arr3 = { 1, 2, 1, 2, 1 };
        int k3 = 3;
        System.out.println("Test Case 3: [1,2,1,2,1], k=3 -> Count: " + sl.subarraySum(arr3, k3));
    }
}
