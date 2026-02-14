package SlidingWindow_TwoPointer;

import java.util.HashMap;

public class LengthOfLongestSubString {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            /*
             * Pseudocode (Optimal - O(N) Time, O(Min(N, M)) Space):
             * 1. Use two pointers 'left' and 'right' and a HashMap to store char ->
             * lastIndex.
             * 2. Iterate 'right' from 0 to n-1:
             * a. If s[right] is in map, update 'left' to max(left, map.get(s[right]) + 1).
             * b. Update map with current index: map.put(s[right], right).
             * c. Calculate window length: len = right - left + 1.
             * d. Update maxLen.
             * 3. Return maxLen.
             * 
             * Alternative (Array): Use int[256] array if ASCII.
             */

            HashMap<Character, Integer> map = new HashMap<>(); // Standard ASCII support
            int n = s.length();
            int left = 0;
            int maxLen = 0;

            for (int right = 0; right < n; right++) {
                char currentChar = s.charAt(right);

                if (map.containsKey(currentChar)) {
                    // Move left pointer to right of previous occurrence
                    // But prevent moving left backwards (if prev occurrence is before current left)
                    left = Math.max(left, map.get(currentChar) + 1);
                }

                map.put(currentChar, right);
                maxLen = Math.max(maxLen, right - left + 1);
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        // Example 1: "abcabcbb" -> 3 ("abc")
        // Example 2: "bbbbb" -> 1 ("b")
        // Example 3: "pwwkew" -> 3 ("wke")

        Solution sl = new Solution();

        System.out.println("abcabcbb -> " + sl.lengthOfLongestSubstring("abcabcbb"));
        System.out.println("bbbbb -> " + sl.lengthOfLongestSubstring("bbbbb"));
        System.out.println("pwwkew -> " + sl.lengthOfLongestSubstring("pwwkew"));
        System.out.println(" " + " -> " + sl.lengthOfLongestSubstring(" ")); // Space char
    }
}
