package String;

public class StringToInt {
    static class Solution {
        /*
         * Pseudocode (String to Integer (atoi) - O(N)):
         * Goal: Convert string to 32-bit signed integer handling whitespace, signs, and
         * overflow.
         * 
         * 1. Skip leading whitespace.
         * 2. Check for optional sign ('+' or '-').
         * 3. Read input digit by digit until a non-digit is encountered or end of
         * string.
         * 4. Convert digits to integer:
         * - Maintain `long ans` to check for overflow.
         * - ans = ans * 10 + digit.
         * - If ans exceeds Integer.MAX_VALUE/MIN_VALUE limits, clamp it and return.
         * 5. Apply sign and return result.
         */
        public int myAtoi(String s) {
            int i = 0;
            int n = s.length();
            int sign = 1;

            // 1. Skip whitespace
            while (i < n && s.charAt(i) == ' ') {
                i++;
            }

            if (i == n)
                return 0;

            // 2. Check Sign
            if (s.charAt(i) == '-') {
                sign = -1;
                i++;
            } else if (s.charAt(i) == '+') {
                sign = 1;
                i++;
            }

            long ans = 0;

            // 3. Read digits
            while (i < n && Character.isDigit(s.charAt(i))) {
                int digit = s.charAt(i) - '0';

                // Check overflow before updating or use long and check after
                ans = ans * 10 + digit;

                // Clamp if overflow
                if (sign == 1 && ans > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (sign == -1 && -ans < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }

                i++;
            }

            return (int) (sign * ans);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard
        System.out.println("Test Case 1: " + solution.myAtoi("42"));
        // Expected: 42

        // Test Case 2: Negative and whitespace
        System.out.println("Test Case 2: " + solution.myAtoi("   -42"));
        // Expected: -42

        // Test Case 3: With words
        System.out.println("Test Case 3: " + solution.myAtoi("4193 with words"));
        // Expected: 4193

        // Test Case 4: Overflow
        System.out.println("Test Case 4: " + solution.myAtoi("919999999999")); // Greater than Integer.MAX_VALUE
        // Expected: 2147483647 (Integer.MAX_VALUE)

        // Test Case 5: Underflow
        System.out.println("Test Case 5: " + solution.myAtoi("-919999999999")); // Less than Integer.MIN_VALUE
        // Expected: -2147483648 (Integer.MIN_VALUE)
    }
}
