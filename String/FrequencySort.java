package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencySort {
    static class Solution {
        /*
         * Pseudocode (Sort Characters By Frequency - O(N)):
         * Goal: Sort string in decreasing order based on frequency of characters.
         * 
         * Strategy: Bucket Sort
         * 1. Count Frequencies: Use a HashMap/Array to count occurrences of each char.
         * 2. logic buckets: Create an array of Lists where index 'i' stores characters
         * that appear exactly 'i' times.
         * - Max frequency is length of string (N). So bucket array size is N + 1.
         * 3. Fill Buckets: Iterate through the map and add chars to their respective
         * frequency buckets.
         * 4. Build Result: Iterate from the last bucket (highest frequency) down to 1.
         * - For each char in bucket[i], append it 'i' times to the result.
         * 5. Return result string.
         */
        public String frequencySort(String s) {
            Map<Character, Integer> counts = new HashMap<>();
            for (char c : s.toCharArray()) {
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            // Bucket array where index represents frequency
            List<Character>[] buckets = new List[s.length() + 1];
            for (char key : counts.keySet()) {
                int frequency = counts.get(key);
                if (buckets[frequency] == null) {
                    buckets[frequency] = new ArrayList<>();
                }
                buckets[frequency].add(key);
            }

            StringBuilder res = new StringBuilder();
            // Iterate from highest frequency to 1
            for (int i = buckets.length - 1; i >= 1; i--) {
                if (buckets[i] != null) {
                    for (char c : buckets[i]) {
                        // Append the character 'i' times
                        for (int j = 0; j < i; j++) {
                            res.append(c);
                        }
                    }
                }
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case
        String s1 = "tree";
        System.out.println("Test Case 1: \"" + solution.frequencySort(s1) + "\"");
        // Expected: "eert" or "eetr"

        // Test Case 2: Three distinct
        String s2 = "cccaaa";
        System.out.println("Test Case 2: \"" + solution.frequencySort(s2) + "\"");
        // Expected: "cccaaa" or "aaaccc"

        // Test Case 3: All same
        String s3 = "Aabb";
        System.out.println("Test Case 3: \"" + solution.frequencySort(s3) + "\"");
        // Expected: "bbAa" or "bbaA"
    }
}
