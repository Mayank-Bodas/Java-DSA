package Basics;

public class ReverseNumber {
    public static int reverseNumber(int n){
        int revNum = 0;
        while (n>0) {
            int lastDigit = n % 10;
            revNum = revNum * 10 + lastDigit;
            n=n/10; 
        }
        return revNum;
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println("Reverse Number : " +reverseNumber(num)); 
    }
}
