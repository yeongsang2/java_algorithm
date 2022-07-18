package baekjoon;

import java.util.Scanner;

public class 피보나치수5_10870 {

    private static int fib(int n){
        if(n == 0) {
            return 0;
        }
        else if( n ==1){
            return 1;
        }

        return fib(n-1) + fib(n-2);
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int result = fib(n);
        System.out.println(result);
    }
}
