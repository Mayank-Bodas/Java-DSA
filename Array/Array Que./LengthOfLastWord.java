package Array;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int last = s.length() - 1;
        int count = 0;
        while (last >= 0 && s.charAt(last) == ' ') {
            last--;
        }
        while (last >= 0 && s.charAt(last) != ' ') {
            count++;
            last--;
        }
        return count;
    }
}