package String;

public class MaxDepthParenthesis {
    static class Solution {
        /*
         * Pseudocode (Maximum Nesting Depth of the Parentheses - O(N)):
         * Goal: Return the maximum depth of nested parentheses.
         * 
         * 1. Initialize `currentDepth` = 0, `maxDepth` = 0.
         * 2. Iterate through each character in string `s`:
         * a. If char is '(':
         * - Increment `currentDepth`.
         * - Update `maxDepth` = max(maxDepth, currentDepth). (Update immediately as
         * this is a new depth)
         * b. If char is ')':
         * - Decrement `currentDepth`.
         * 3. Return `maxDepth`.
         */
        public int maxDepth(String s) {
            int currentDepth = 0;
            int maxDepth = 0;

            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    currentDepth++;
                    maxDepth = Math.max(maxDepth, currentDepth);
                } else if (ch == ')') {
                    currentDepth--;
                }
            }
            return maxDepth;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard nested
        String s1 = "(1+(2*3)+((8)/4))+1";
        System.out.println("Test Case 1: " + solution.maxDepth(s1));
        // Expected: 3

        // Test Case 2: No nesting
        String s2 = "(1)+((2))+(((3)))";
        System.out.println("Test Case 2: " + solution.maxDepth(s2));
        // Expected: 3

        // Test Case 3: Flat
        String s3 = "1+(2*3)/(2-1)";
        System.out.println("Test Case 3: " + solution.maxDepth(s3));
        // Expected: 1

        // Test Case 4: No parentheses
        String s4 = "1+2+3";
        System.out.println("Test Case 4: " + solution.maxDepth(s4));
        // Expected: 0
    }
}
