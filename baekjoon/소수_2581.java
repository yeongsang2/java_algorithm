package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class 소수_2581 {

    private static List<Integer> list = new ArrayList<>();
    private static int sum = 0;
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        for(int i = m ; m < n+1; m++) {
            checkPrime(m);
        }
        list.
        if(list.isEmpty()){
            System.out.println(-1);
        }else {
            Integer min = Collections.min(list);
            System.out.println(sum);
            System.out.println(min);
        }
    }

    private static void checkPrime(int a){
        int t = 0;
        for(int i = 1 ; i < a+1 ; i++){
            if(a % i == 0){
                t++;
            }
        }
        if( t ==2 ){
            list.add(a);
            sum += a;
        }
    }
}
