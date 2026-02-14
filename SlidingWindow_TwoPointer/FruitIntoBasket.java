package SlidingWindow_TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBasket {
    static class Solution {
        public int totalFruit(int[] fruits) {
            /*
             * Pseudocode (Fruit Into Baskets - Longest Subarray with at most 2 distinct -
             * O(N)):
             * 1. Initialize left = 0, right = 0, maxLen = 0.
             * 2. Use a HashMap<Integer, Integer> to store count of each fruit type in
             * window.
             * 3. Loop right from 0 to n-1:
             * a. Add fruits[right] to map.
             * b. While map.size() > 2:
             * - Remove/decrement fruits[left] from map.
             * - If count becomes 0, remove key from map.
             * - left++.
             * c. Update maxLen = max(maxLen, right - left + 1).
             * 4. Return maxLen.
             */

            Map<Integer, Integer> map = new HashMap<>();
            int left = 0;
            int maxLen = 0;
            int n = fruits.length;

            for (int right = 0; right < n; right++) {
                map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

                while (map.size() > 2) {
                    if (map.containsKey(fruits[left])) {
                        map.put(fruits[left], map.get(fruits[left]) - 1);
                        if (map.get(fruits[left]) == 0) {
                            map.remove(fruits[left]);
                        }
                    }
                    left++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        // Example 1: [1,2,1] -> 3
        int[] fruits1 = { 1, 2, 1 };
        Solution sl = new Solution();
        System.out.println("Fruits: [1,2,1] -> " + sl.totalFruit(fruits1));

        // Example 2: [0,1,2,2] -> 3
        int[] fruits2 = { 0, 1, 2, 2 };
        System.out.println("Fruits: [0,1,2,2] -> " + sl.totalFruit(fruits2));

        // Example 3: [1,2,3,2,2] -> 4
        int[] fruits3 = { 1, 2, 3, 2, 2 };
        System.out.println("Fruits: [1,2,3,2,2] -> " + sl.totalFruit(fruits3));
    }
}
