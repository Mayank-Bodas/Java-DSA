package String;

import java.util.Arrays;

public class LongestCommonPrefix {
    static class Solution {
        /*
         * Pseudocode (Longest Common Prefix - Sorting Approach):
         * Goal: Find the longest common prefix string amongst an array of strings.
         * 
         * 1. Check edge cases: if strs is null or empty, return "".
         * 2. Sort the array of strings.
         * - Why? Sorting brings strings with similar prefixes together.
         * - The longest common prefix must be a prefix of the FIRST and the LAST string
         * (since they differ the most).
         * 3. Compare the first and last strings character by character.
         * 4. Stop at the first mismatch.
         * 5. Return the substring up to the mismatch index.
         * 
         * Time Complexity: O(N * L * log N) due to sorting (where N is array size, L is
         * max string length).
         * Space Complexity: O(1) (ignoring sort stack space).
         */
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0) {
                return "";
            }

            Arrays.sort(strs);
            String first = strs[0];
            String last = strs[strs.length - 1];
            int i = 0;

            while (i < first.length() && i < last.length()) {
                if (first.charAt(i) == last.charAt(i)) {
                    i++;
                } else {
                    break;
                }
            }
            return first.substring(0, i);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Common prefix exists
        String[] strs1 = { "flower", "flow", "flight" };
        System.out.println("Test Case 1: \"" + solution.longestCommonPrefix(strs1) + "\"");
        // Expected: "fl"

        // Test Case 2: No common prefix
        String[] strs2 = { "dog", "racecar", "car" };
        System.out.println("Test Case 2: \"" + solution.longestCommonPrefix(strs2) + "\"");
        // Expected: ""

        // Test Case 3: Single string (should return itself)
        String[] strs3 = { "single" };
        System.out.println("Test Case 3: \"" + solution.longestCommonPrefix(strs3) + "\"");
        // Expected: "single"

        // Test Case 4: Empty array
        String[] strs4 = {};
        System.out.println("Test Case 4: \"" + solution.longestCommonPrefix(strs4) + "\"");
        // Expected: ""
    }
}
