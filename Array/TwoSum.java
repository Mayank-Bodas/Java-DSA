package Array;

import java.util.*;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // Map to store number -> its index
        Map<Integer,Integer> pairIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            
            // Check if the "complement" exists in the map
            if (pairIdx.containsKey(target - num)) {
                // If yes, return current index and the index of the complement
                return new int[] { i, pairIdx.get(target - num) };
            }

            // Otherwise, store this number and its index in the map
            pairIdx.put(num, i);
        }
        // If no pair is found (shouldn't happen in valid input)
        return new int[]{};
    }
}

