package baekjoon;

import java.util.*;

public class 최대공약수와최소공배수_2609 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if( b > a){
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println(gcd(a,b));
        System.out.println(lcm(a,b));

    }
    // 최대 공약수 알고리즘
    // a % b 의 나머지(n) 0이면 b가 최대공약수
    // n이 0이 아닐시 a = b , b= n
    private static int gcd(int a, int b){
        while(b!=0){
            int n = a % b;
            a = b;
            b = n;
        }
        return a;

    }
    // 최대공약수 a * b * gcd
    private static int lcm(int a, int b){
        return (a*b/gcd(a,b));
    }
}
