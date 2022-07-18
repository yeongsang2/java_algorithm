package baekjoon;

import java.util.*;
public class 소수찾기_1978 {

    private static int cnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0; i< n; i++){

            checkPrime(sc.nextInt());
        }
        System.out.println(cnt);
    }
    private static void checkPrime(int a){

        int num=0;
        // 소수 약수가 자기 자신이랑 1뿐
        for(int i =1 ; i <= a; i++){
            if( a % i == 0){
                num++;
            }
        }
        if(num == 2){
            cnt++;
        }
    }
}
