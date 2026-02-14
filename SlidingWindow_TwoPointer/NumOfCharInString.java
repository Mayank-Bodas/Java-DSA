package SlidingWindow_TwoPointer;

public class NumOfCharInString {
    static class Solution {
        public int numberOfSubstrings(String s) {
            /*
             * Pseudocode (Number of Substrings Containing All Three Characters - O(N)):
             * Goal: Count valid substrings containing at least one 'a', 'b', and 'c'.
             * 
             * 1. Initialize left=0, right=0, count=0, freq[3].
             * 2. Loop right from 0 to n-1:
             * a. Increment freq of s[right].
             * b. While freq[0]>0 && freq[1]>0 && freq[2]>0 (Valid Window):
             * - We found a valid window [left, right].
             * - Since [left, right] is valid, any substring [left, k] where k >= right is
             * also valid.
             * - Valid substrings ending at or after 'right' starting from 'left': (n -
             * right).
             * - count += (n - right).
             * - Shrink window: Decrement freq[s[left]], left++.
             * 3. Return count.
             */

            int[] freq = new int[3];
            int left = 0;
            int count = 0;
            int n = s.length();

            for (int right = 0; right < n; right++) {
                freq[s.charAt(right) - 'a']++;

                while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                    // All substrings starting from 'left' and ending at 'right' or beyond are valid
                    count += (n - right);

                    freq[s.charAt(left) - 'a']--;
                    left++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        // Example 1: "abcabc" -> 10
        String s1 = "abcabc";
        Solution sl = new Solution();
        System.out.println("S: abcabc -> " + sl.numberOfSubstrings(s1));

        // Example 2: "aaacb" -> 3 ("aaacb", "aacb", "acb")
        String s2 = "aaacb";
        System.out.println("S: aaacb -> " + sl.numberOfSubstrings(s2));

        // Example 3: "abc" -> 1
        String s3 = "abc";
        System.out.println("S: abc -> " + sl.numberOfSubstrings(s3));
    }
}
