package String;

import java.util.HashMap;
import java.util.Map;

public class CharFreqInStr {

    /*
     * Pseudocode (Character Frequency - O(N)):
     * Goal: Count the frequency of each character in a string.
     * 
     * Algorithm using HashMap:
     * 1. Initialize an empty HashMap `freqMap`.
     * 2. Iterate through each character `c` in the string `s`:
     * - Update the count: `freqMap.put(c, freqMap.getOrDefault(c, 0) + 1)`.
     * 3. Return `freqMap`.
     * 
     * Time Complexity: O(N) where N is the length of the string.
     * Space Complexity: O(K) where K is the number of unique characters.
     */
    public static Map<Character, Integer> getCharFrequency(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        if (s == null)
            return freqMap; // Return empty map for null input

        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        return freqMap;
    }

    public static void main(String[] args) {
        // Test Case 1: Simple string
        // Input: "mayank"
        // Expected: {a=2, m=1, y=1, n=1, k=1} (Order in HashMap is not guaranteed, but
        // counts are)
        String s1 = "mayank";
        System.out.println("Test Case 1: " + s1);
        System.out.println("Frequency: " + getCharFrequency(s1));

        // Test Case 2: String with spaces and special chars
        // Input: "hello world"
        // Expected: {h=1, e=1, l=3, o=2, w=1, r=1, d=1, =1}
        String s2 = "hello world";
        System.out.println("\nTest Case 2: " + s2);
        System.out.println("Frequency: " + getCharFrequency(s2));

        // Test Case 3: Empty string
        // Input: ""
        // Expected: {}
        String s3 = "";
        System.out.println("\nTest Case 3: (Empty String)");
        System.out.println("Frequency: " + getCharFrequency(s3));

        // Test Case 4: Null string
        // Input: null
        // Expected: {}
        String s4 = null;
        System.out.println("\nTest Case 4: (Null)");
        System.out.println("Frequency: " + getCharFrequency(s4));
    }
}
