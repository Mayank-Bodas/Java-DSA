package String;

import java.util.HashMap;
import java.util.Map;

public class CountSubString {
    static class Solution {
        /*
         * Pseudocode (Count Substrings with K Distinct Characters - O(N)):
         * Goal: Count substrings with exactly k distinct characters.
         * 
         * Logic:
         * 1. Formula: exactly(k) = atMost(k) - atMost(k - 1).
         * - Why? 'atMost(k)' includes substrings with 1, 2, ..., k distinct chars.
         * - 'atMost(k-1)' includes substrings with 1, 2, ..., k-1 distinct chars.
         * - Subtracting them leaves only substrings with exactly k distinct chars.
         * 
         * atMost(s, k) Algorithm:
         * 1. Use Sliding Window with 'left' and 'right' pointers.
         * 2. Use a Map to track character frequencies in current window.
         * 3. Expand 'right': Add s[right] to map.
         * 4. While map.size() > k (too many distinct chars):
         * - Shrink 'left': Remove s[left] from map.
         * - If frequency becomes 0, remove key from map.
         * - Increment 'left'.
         * 5. Add (right - left + 1) to result.
         * - This counts all valid substrings ending at 'right' with <= k distinct
         * chars.
         * 6. Return total count.
         */
        public int countSubstrings(String s, int k) {
            return atmostKDistinct(s, k) - atmostKDistinct(s, k - 1);
        }

        private int atmostKDistinct(String s, int k) {
            if (k < 0)
                return 0;

            int left = 0;
            int res = 0;
            Map<Character, Integer> map = new HashMap<>();

            for (int right = 0; right < s.length(); right++) {
                map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

                while (map.size() > k) {
                    char leftChar = s.charAt(left);
                    map.put(leftChar, map.get(leftChar) - 1);
                    if (map.get(leftChar) == 0) {
                        map.remove(leftChar);
                    }
                    left++;
                }

                res += right - left + 1;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard
        String s1 = "aba";
        int k1 = 2;
        System.out.println("Test Case 1: " + solution.countSubstrings(s1, k1));
        // Expected: 3 ("ab", "ba", "aba")
        // atMost(2) = "a", "b", "a", "ab", "ba", "aba" (6)
        // atMost(1) = "a", "b", "a" (3)
        // 6 - 3 = 3

        // Test Case 2: K=1
        String s2 = "aba";
        int k2 = 1;
        System.out.println("Test Case 2: " + solution.countSubstrings(s2, k2));
        // Expected: 3 ("a", "b", "a")

        // Test Case 3: All distinct
        String s3 = "abc";
        int k3 = 3;
        System.out.println("Test Case 3: " + solution.countSubstrings(s3, k3));
        // Expected: 1 ("abc")
    }
}
