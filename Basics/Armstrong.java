package Basics;

public class Armstrong {
    public static boolean isArmstrong(int num) {
        int k = String.valueOf(num).length();
        int sum = 0;
        int n = num;

        while (n > 0) {
            int ld = n % 10;
            sum += (int) Math.pow(ld, k);
            n /= 10;
        }
        return sum == num;
    }

    public static void main(String[] args) {
        int number = 153;
        if (isArmstrong(number)) {
            System.out.println(number + " is an Armstrong number.");
        } else {
            System.out.println(number + " is not an Armstrong number.");
        }
    }
}
