package String;

public class Anagram {
    static class Solution {
        /*
         * Pseudocode (Valid Anagram - O(N)):
         * Goal: Check if 's' and 't' are anagrams (contain same characters with same
         * frequencies).
         * 
         * 1. Check lengths: if s.length != t.length, return false.
         * 2. Initialize frequency array `count` of size 26 (assuming lowercase English
         * letters).
         * 3. Loop through strings:
         * - Increment count for char in 's'.
         * - Decrement count for char in 't'.
         * 4. Verify count array:
         * - If any value is non-zero, return false.
         * 5. Return true.
         */
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }

            int[] count = new int[26];
            for (int i = 0; i < s.length(); i++) {
                // Assuming lowercase English letters
                count[s.charAt(i) - 'a']++;
                count[t.charAt(i) - 'a']--;
            }

            for (int c : count) {
                if (c != 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard Anagram
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println("Test Case 1: " + solution.isAnagram(s1, t1));
        // Expected: true

        // Test Case 2: Not Anagram
        String s2 = "rat";
        String t2 = "car";
        System.out.println("Test Case 2: " + solution.isAnagram(s2, t2));
        // Expected: false

        // Test Case 3: Different Lengths
        String s3 = "a";
        String t3 = "ab";
        System.out.println("Test Case 3: " + solution.isAnagram(s3, t3));
        // Expected: false
    }
}
