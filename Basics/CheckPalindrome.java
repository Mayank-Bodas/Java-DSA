package Basics;

public class CheckPalindrome {
    public static void main(String[] args) {
        int num = 123245;
        int dup = num;
        int revNum = 0;
        while(num > 0){
            int lastDigit = num % 10;
            revNum = revNum * 10 + lastDigit;
            num = num /10;
        }
        System.out.println("Palindrome : " +(revNum == dup));
    }
}
