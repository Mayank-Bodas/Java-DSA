package String;

public class RomanToInt {
    static class Solution {
        /*
         * Pseudocode (Roman to Integer - O(N)):
         * Goal: Convert Roman numeral string to integer.
         * 
         * Logic:
         * 1. Initialize `sum` = 0.
         * 2. Iterate through string from left to right (0 to N-1).
         * 3. For each character `s[i]`:
         * - Get value of current char: val(s[i]).
         * - Check next char: if i < N-1 and val(s[i]) < val(s[i+1]):
         * - Subtraction rule applies (e.g., IV = 4).
         * - Subtract current value from sum: sum -= val(s[i]).
         * - Else:
         * - Add current value to sum: sum += val(s[i]).
         * 4. Return `sum`.
         */
        public int romanToInt(String s) {
            int sum = 0;
            int n = s.length();

            for (int i = 0; i < n; i++) {
                int currentVal = getValue(s.charAt(i));

                // Check if we need to subtract (lookahead)
                if (i < n - 1 && currentVal < getValue(s.charAt(i + 1))) {
                    sum -= currentVal;
                } else {
                    sum += currentVal;
                }
            }
            return sum;
        }

        private int getValue(char c) {
            switch (c) {
                case 'I':
                    return 1;
                case 'V':
                    return 5;
                case 'X':
                    return 10;
                case 'L':
                    return 50;
                case 'C':
                    return 100;
                case 'D':
                    return 500;
                case 'M':
                    return 1000;
                default:
                    return 0;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1
        String s1 = "III";
        System.out.println("Test Case 1: " + solution.romanToInt(s1));
        // Expected: 3

        // Test Case 2
        String s2 = "LVIII";
        System.out.println("Test Case 2: " + solution.romanToInt(s2));
        // Expected: 58

        // Test Case 3
        String s3 = "MCMXCIV";
        System.out.println("Test Case 3: " + solution.romanToInt(s3));
        // Expected: 1994 (1000 + 900 + 90 + 4)
    }
}
