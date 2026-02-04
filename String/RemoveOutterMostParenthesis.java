package String;

public class RemoveOutterMostParenthesis {
    static class Solution {
        /*
         * Pseudocode (Remove Outermost Parentheses - O(N)):
         * Goal: Remove the outer parentheses of every primitive decomposition of S.
         * 
         * 1. Initialize `count` = 0 to track open parentheses depth.
         * 2. Initialize `StringBuilder` res.
         * 3. Iterate through string chars:
         * a. If char is '(':
         * - If count > 0, append '(' (it's inside outermost).
         * - Increment count.
         * b. If char is ')':
         * - Decrement count.
         * - If count > 0, append ')' (it's inside outermost).
         * 4. Return res.toString().
         */
        public String removeOuterParentheses(String s) {
            StringBuilder res = new StringBuilder();
            int level = 0;
            for (char ch : s.toCharArray()) {
                if (ch == '(') {
                    if (level > 0)
                        res.append(ch);
                    level++;
                } else if (ch == ')') {
                    level--;
                    if (level > 0)
                        res.append(ch);
                }
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "(()())(())";
        System.out.println("Test Case 1: " + solution.removeOuterParentheses(s1));
        // Expected: "()()()"

        // Test Case 2
        String s2 = "(()())(())(()(()))";
        System.out.println("Test Case 2: " + solution.removeOuterParentheses(s2));
        // Expected: "()()()()(())"

        // Test Case 3
        String s3 = "()()";
        System.out.println("Test Case 3: " + solution.removeOuterParentheses(s3));
        // Expected: "" (Empty string)
    }
}
