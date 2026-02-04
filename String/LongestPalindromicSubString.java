package String;

public class LongestPalindromicSubString {
    static class Solution {
        /*
         * Pseudocode (Longest Palindromic Substring - O(N^2)):
         * Goal: Find the longest substring that is a palindrome.
         * 
         * Algorithm: Expand Around Center.
         * 1. A palindrome mirrors around a center.
         * - Odd length: center is a character (e.g., "aba" center 'b').
         * - Even length: center is between two characters (e.g., "abba" center between
         * 'b's).
         * 2. Loop through each index `i` from 0 to s.length()-1:
         * a. Expand for odd length: `expand(i, i)`.
         * b. Expand for even length: `expand(i, i+1)`.
         * c. Max Length = max(Odd Length, Even Length).
         * d. If Max Length > (current best end - start):
         * - Update `start` and `end` indices based on new max length and center `i`.
         * 3. Return substring from `start` to `end + 1`.
         * 
         * Time Complexity: O(N^2) - N centers, each expansion max O(N).
         */
        public String longestPalindrome(String s) {
            if (s == null || s.length() < 1)
                return "";

            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                // Odd length palindrome
                int len1 = expandAroundCenter(s, i, i);
                // Even length palindrome
                int len2 = expandAroundCenter(s, i, i + 1);

                int len = Math.max(len1, len2);

                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);
        }

        private int expandAroundCenter(String s, int left, int right) {
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            // Length is (right - 1) - (left + 1) + 1 = right - left - 1
            return right - left - 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Odd length
        String s1 = "babad";
        System.out.println("Test Case 1: " + solution.longestPalindrome(s1));
        // Expected: "bab" or "aba"

        // Test Case 2: Even length
        String s2 = "cbbd";
        System.out.println("Test Case 2: " + solution.longestPalindrome(s2));
        // Expected: "bb"

        // Test Case 3: Entire string
        String s3 = "racecar";
        System.out.println("Test Case 3: " + solution.longestPalindrome(s3));
        // Expected: "racecar"

        // Test Case 4: Single char
        String s4 = "a";
        System.out.println("Test Case 4: " + solution.longestPalindrome(s4));
        // Expected: "a"
    }
}
