package String;

public class LargestOddnumber {
    static class Solution {
        /*
         * Pseudocode (Largest Odd Number in String - O(N)):
         * Goal: Return the largest-valued odd integer that is a non-empty substring of
         * 'num'.
         * 
         * Logic:
         * 1. Iterate from the end of the string (i = num.length - 1) down to 0.
         * 2. Check each digit: if (num.charAt(i) is odd).
         * 3. If odd found:
         * - The largest odd number corresponds to the substring exactly up to this
         * digit.
         * - Why? Because any substring ending at this 'i' is smaller if we act,
         * and any substring ending *after* 'i' is even (since we are scanning from
         * right).
         * - Return num.substring(0, i + 1). (This preserves the magnitude).
         * 4. If loop completes without finding an odd digit, return "".
         */
        public String largestOddNumber(String num) {
            for (int i = num.length() - 1; i >= 0; i--) {
                char c = num.charAt(i);
                // Check if digit is odd (ascii value of odd digits is odd)
                if ((c - '0') % 2 != 0) {
                    return num.substring(0, i + 1);
                }
            }
            return "";
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String num1 = "52";
        System.out.println("Test Case 1: \"" + solution.largestOddNumber(num1) + "\"");
        // Expected: "5"

        // Test Case 2
        String num2 = "4206";
        System.out.println("Test Case 2: \"" + solution.largestOddNumber(num2) + "\"");
        // Expected: ""

        // Test Case 3
        String num3 = "35427";
        System.out.println("Test Case 3: \"" + solution.largestOddNumber(num3) + "\"");
        // Expected: "35427"
    }
}
