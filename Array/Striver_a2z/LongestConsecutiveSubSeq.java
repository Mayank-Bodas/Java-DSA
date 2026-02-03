package Array.Striver_a2z;

import java.util.HashSet;

public class LongestConsecutiveSubSeq {
    static class Solution {
        public int longestConsecutive(int[] nums) {
            /*
             * Pseudocode (Optimal - O(N)):
             * 1. Create a HashSet 'set' to store unique elements.
             * 2. Add all elements of 'nums' to 'set'.
             * 3. Initialize 'longestStreak' to 0.
             * 4. Iterate through 'nums':
             * a. If 'num - 1' is not in 'set', it means 'num' is the start of a sequence.
             * b. Initialize 'currentNum' = 'num' and 'currentStreak' = 1.
             * c. While 'currentNum + 1' is in 'set':
             * - Increment 'currentNum' by 1.
             * - Increment 'currentStreak' by 1.
             * d. Update 'longestStreak' = max(longestStreak, currentStreak).
             * 5. Return 'longestStreak'.
             */

            int n = nums.length;
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                set.add(nums[i]);
            }
            int longestStreak = 0;

            // Iterate over the set to avoid processing duplicates
            for (int num : set) {
                // If num-1 is not in set, it's the start of a sequence
                if (!set.contains(num - 1)) {
                    int currentNum = num;
                    int currentStreak = 1;

                    while (set.contains(currentNum + 1)) {
                        currentNum += 1;
                        currentStreak += 1;
                    }
                    longestStreak = Math.max(longestStreak, currentStreak);
                }
            }
            return longestStreak;
        }
    }

    public static void main(String[] args) {
        // Example: [100, 4, 200, 1, 3, 2]
        // Sequence: 1, 2, 3, 4. Length: 4.
        int[] arr = { 100, 4, 200, 1, 3, 2 };

        System.out.print("Array: ");
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();

        Solution sl = new Solution();
        int result = sl.longestConsecutive(arr);

        System.out.println("Longest Consecutive Sequence Length: " + result);
    }
}
