package Array.Striver_a2z;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            /*
             * Pseudocode (Optimal - HashMap O(N)):
             * 1. Initialize a HashMap to store {value -> index}.
             * 2. Traverse the array with index 'i'.
             * 3. Calculate 'complement' = target - nums[i].
             * 4. Check if 'complement' exists in the map.
             * a. If yes, return {map.get(complement), i}.
             * 5. If not, add {nums[i] -> i} to the map.
             * 6. Return {-1, -1} if no solution found (though problem guarantees one).
             * 
             * Complexity:
             * - Time: O(N) - Single pass.
             * - Space: O(N) - To store elements in map.
             */

            HashMap<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];

                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }

                map.put(nums[i], i);
            }
            return new int[] { -1, -1 };
        }
    }

    public static void main(String[] args) {
        int[] arr = { 2, 6, 5, 8, 11 };
        int target = 14;

        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Target: " + target);

        Solution sl = new Solution();
        int[] result = sl.twoSum(arr, target);

        System.out.println("Indices: " + Arrays.toString(result));
    }
}
