package String;

public class BeautySum {
    static class Solution {
        /*
         * Pseudocode (Sum of Beauty of All Substrings - O(N^2)):
         * Goal: Sum of beauty (max_freq - min_freq) for all substrings.
         * 
         * Logic:
         * 1. Iterate through all possible starting positions `i` (0 to N-1).
         * 2. For each `i`, iterate through all ending positions `j` (i to N-1).
         * - This defines a substring s[i...j].
         * 3. Maintain an integer array `freq` (size 26) for the current substring.
         * - As `j` increases, simply increment the count of s[j] in the array.
         * 4. Calculate Beauty:
         * - Find `max` frequency in `freq`.
         * - Find `min` frequency in `freq` (ignore zeros).
         * - Add (max - min) to total `sum`.
         * 5. Return `sum`.
         */
        public int beautySum(String s) {
            int sum = 0;
            int n = s.length();

            for (int i = 0; i < n; i++) {
                int[] freq = new int[26]; // Reset freq for each new starting point

                for (int j = i; j < n; j++) {
                    // Update frequency for current character
                    freq[s.charAt(j) - 'a']++;

                    // Calculate beauty for current substring s[i...j]
                    int max = Integer.MIN_VALUE;
                    int min = Integer.MAX_VALUE;

                    for (int k = 0; k < 26; k++) {
                        if (freq[k] > 0) {
                            max = Math.max(max, freq[k]);
                            min = Math.min(min, freq[k]);
                        }
                    }

                    sum += (max - min);
                }
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "aabcb";
        System.out.println("Test Case 1: " + solution.beautySum(s1));
        // Expected: 5
        // Substrings: "aab" (2-1=1), "aabc" (2-1=1), "aabcb" (2-1=1), "abcb" (2-1=1),
        // "bcb" (2-1=1). Sum = 5

        // Test Case 2
        String s2 = "aabcbaa";
        System.out.println("Test Case 2: " + solution.beautySum(s2));
        // Expected: 17
    }
}
