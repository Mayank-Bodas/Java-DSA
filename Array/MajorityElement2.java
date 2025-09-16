package Array;

import java.util.*;

public class MajorityElement2 {
    public List<Integer> majorityElement(int[] nums) {
        // Two possible majority elements (can be at most 2 for n/3 case)
        Integer majority1 = 0;
        Integer majority2 = 0;

        // Their respective counters
        int count1 = 0;
        int count2 = 0;

        // ---------- First Pass ----------
        // Goal: Find two potential candidates that could be majority elements
        for (int num : nums) {
            if (num == majority1) {
                // If current number matches first candidate, increment its count
                count1++;
            } else if (num == majority2) {
                // If current number matches second candidate, increment its count
                count2++;
            } else if (count1 == 0) {
                // If first candidate has no count, choose this number as first candidate
                majority1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                // If second candidate has no count, choose this number as second candidate
                majority2 = num;
                count2 = 1;
            } else {
                // If current number is different from both candidates,
                // reduce both counts (they "cancel out")
                count1--;
                count2--;
            }
        }

        // ---------- Second Pass ----------
        // Validate if the chosen candidates actually appear > n/3 times
        count1 = 0;
        count2 = 0;

        for (int num : nums) {
            if (num == majority1) {
                count1++;
            } else if (num == majority2) {
                count2++;
            }
        }

        // ---------- Result ----------
        List<Integer> res = new ArrayList<>();
        int n = nums.length;

        if (count1 > n / 3) {
            res.add(majority1);
        }
        if (count2 > n / 3) {
            res.add(majority2);
        }

        return res;
    }
}
