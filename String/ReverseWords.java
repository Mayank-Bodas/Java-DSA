package String;

public class ReverseWords {
    static class Solution {
        /*
         * Pseudocode (Reverse Words in a String - O(N)):
         * Goal: Return a string of the words in reverse order concatenated by a single
         * space.
         * Note: S may contain leading/trailing spaces or multiple spaces between two
         * words.
         * 
         * 1. Initialize StringBuilder `res`.
         * 2. Start iterating from the end of the string (i = s.length - 1).
         * 3. Loop while i >= 0:
         * a. Skip trailing spaces: while s[i] == ' ', i--.
         * b. If i < 0, break.
         * c. Mark end of word: end = i.
         * d. Find start of word: while s[i] != ' ', i--.
         * e. Extract word: substring(i + 1, end + 1).
         * f. Append to `res`:
         * - If `res` not empty, append " ".
         * - Append word.
         * 4. Return res.toString().
         */
        public String reverseWords(String s) {
            StringBuilder res = new StringBuilder();
            int i = s.length() - 1;
            while (i >= 0) {
                while (i >= 0 && s.charAt(i) == ' ') {
                    i--;
                }
                if (i < 0)
                    break;
                int end = i;
                while (i >= 0 && s.charAt(i) != ' ') {
                    i--;
                }
                String word = s.substring(i + 1, end + 1);
                if (res.length() > 0) {
                    res.append(" ");
                }
                res.append(word);
            }
            return res.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case
        String s1 = "the sky is blue";
        System.out.println("Test Case 1: \"" + solution.reverseWords(s1) + "\"");
        // Expected: "blue is sky the"

        // Test Case 2: Leading/trailing spaces
        String s2 = "  hello world  ";
        System.out.println("Test Case 2: \"" + solution.reverseWords(s2) + "\"");
        // Expected: "world hello"

        // Test Case 3: Multiple spaces between words
        String s3 = "a good   example";
        System.out.println("Test Case 3: \"" + solution.reverseWords(s3) + "\"");
        // Expected: "example good a"
    }
}
