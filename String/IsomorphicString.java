package String;

public class IsomorphicString {
    static class Solution {
        /*
         * Pseudocode (Isomorphic Strings - O(N)):
         * Goal: Determine if s can be replaced to get t.
         * Two strings are isomorphic if characters in 's' can be effectively mapped to
         * 't'.
         * Requirement: No two characters map to the same character, but a character can
         * map to itself.
         * 
         * Strategy: Check "Last Seen Index".
         * 1. Use two integer arrays (size 256 for ASCII) to store the *last seen
         * position* + 1 of each char.
         * - m1 stores mapping for string 's'.
         * - m2 stores mapping for string 't'.
         * 2. Iterate through the strings:
         * a. If m1[s.charAt(i)] != m2[t.charAt(i)]:
         * - This means 's[i]' was last seen at a different position than 't[i]'.
         * - Structural inconsistency -> Return false.
         * b. Update m1[s.charAt(i)] = i + 1.
         * c. Update m2[t.charAt(i)] = i + 1.
         * 3. Return true if loop completes.
         */
        public boolean isIsomorphic(String s, String t) {
            int[] m1 = new int[256];
            int[] m2 = new int[256];
            int n = s.length();

            if (n != t.length())
                return false;

            for (int i = 0; i < n; i++) {
                if (m1[s.charAt(i)] != m2[t.charAt(i)]) {
                    return false;
                }
                m1[s.charAt(i)] = i + 1;
                m2[t.charAt(i)] = i + 1;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard Isomorphic
        String s1 = "egg";
        String t1 = "add";
        System.out.println("Test Case 1: " + solution.isIsomorphic(s1, t1));
        // Expected: true (e->a, g->d)

        // Test Case 2: Not Isomorphic (multiple mapping)
        String s2 = "foo";
        String t2 = "bar";
        System.out.println("Test Case 2: " + solution.isIsomorphic(s2, t2));
        // Expected: false (o cannot map to both a and r)

        // Test Case 3: Standard Isomorphic
        String s3 = "paper";
        String t3 = "title";
        System.out.println("Test Case 3: " + solution.isIsomorphic(s3, t3));
        // Expected: true
    }
}
