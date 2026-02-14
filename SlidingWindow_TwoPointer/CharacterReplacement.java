package SlidingWindow_TwoPointer;

public class CharacterReplacement {
    static class Solution {
        public int characterReplacement(String s, int k) {
            /*
             * Pseudocode (Longest Repeating Character Replacement - O(N)):
             * Goal: Longest substring where we can make all chars same by replacing at most
             * 'k' chars.
             * Formula: (WindowLen - MaxFreqChar) <= k.
             * 
             * 1. Initialize left = 0, right = 0, maxLen = 0, maxCount = 0.
             * 2. Use int[26] to store frequency of characters in current window.
             * 3. Loop right from 0 to n-1:
             * a. Increment count of s[right].
             * b. Update maxCount = max(maxCount, count[s[right]]).
             * c. While (right - left + 1) - maxCount > k:
             * - Window is invalid (too many replacements needed).
             * - Decrement count of s[left].
             * - left++.
             * - (Note: We don't need to decrement maxCount, because for a NEW maxLen,
             * we strictly need a higher maxCount. Keeping old maxCount works for find
             * maxLen).
             * d. Update maxLen = max(maxLen, right - left + 1).
             * 4. Return maxLen.
             */

            int[] count = new int[26];
            int left = 0;
            int maxCount = 0;
            int maxLen = 0;
            int n = s.length();

            for (int right = 0; right < n; right++) {
                char c = s.charAt(right);
                count[c - 'A']++;

                // Track frequency of the most frequent character in the CURRENT window
                // Actually, optimizing simple sliding window:
                // We only need to expand if we find a window with higher maxCount consistent
                // with valid condition.
                maxCount = Math.max(maxCount, count[c - 'A']);

                // If replacements needed > k, shrink window
                if ((right - left + 1) - maxCount > k) {
                    count[s.charAt(left) - 'A']--;
                    left++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        // Example 1: s = "ABAB", k = 2 -> 4 ("AAAA" or "BBBB")
        String s1 = "ABAB";
        int k1 = 2;
        Solution sl = new Solution();
        System.out.println("S: " + s1 + ", K: " + k1 + " -> " + sl.characterReplacement(s1, k1));

        // Example 2: s = "AABABBA", k = 1 -> 4 ("AABA" -> "AAAA" replacement is 1? No.
        // "AAAA" needs 2.
        // "AABABB" -> "AABAB" ? "BBA" -> "BBB"?
        // Longest is 4: "AABA" -> replace B with A -> "AAAA". Correct.
        String s2 = "AABABBA";
        int k2 = 1;
        System.out.println("S: " + s2 + ", K: " + k2 + " -> " + sl.characterReplacement(s2, k2));
    }
}
