package String;

public class RotateString {
    static class Solution {
        /*
         * Pseudocode (Rotate String - O(N)):
         * Goal: Check if 's' can become 'goal' after some number of shifts.
         * 
         * Logic:
         * 1. Check Lengths: If s.length() != goal.length(), rotation is impossible ->
         * Return false.
         * 2. Concatenation Trick:
         * - If we concatenate 's' with itself (s + s), it will contain all possible
         * rotations of 's' as substrings.
         * - Example: s = "abcde", s+s = "abcdeabcde"
         * Rotations: "abcde", "bcdea", "cdeab", "deabc", "eabcd".
         * All are present in "abcdeabcde".
         * 3. Check Contains: Return (s + s).contains(goal).
         */
        public boolean rotateString(String s, String goal) {
            if (s.length() != goal.length()) {
                return false;
            }
            String doubledS = s + s;
            return doubledS.contains(goal);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Valid rotation
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println("Test Case 1: " + solution.rotateString(s1, goal1));
        // Expected: true

        // Test Case 2: Invalid rotation
        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println("Test Case 2: " + solution.rotateString(s2, goal2));
        // Expected: false

        // Test Case 3: Different lengths
        String s3 = "abc";
        String goal3 = "abcd";
        System.out.println("Test Case 3: " + solution.rotateString(s3, goal3));
        // Expected: false
    }
}
