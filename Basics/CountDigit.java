package Basics;

public class CountDigit {
    public static int countDigit(int n){
        //Brute Force Using divide
        // int cnt = 0;
        // while (n>0) {
        //     cnt = cnt + 1;
        //     n=n/10;
        // }
        // return cnt;

        //Optimized Using the log10 to get the digits
        int cnt = (int) (Math.log10(n) + 1);
        return cnt;
    }

    public static void main(String[] args) {
        int N = 325454;
        System.out.println("N : " +N);
        int digits = countDigit(N);
        System.out.println("Number of Digits in N : " + digits);
    }
}