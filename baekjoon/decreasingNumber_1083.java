package baekjoon;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class decreasingNumber_1083 {

    public static List number;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        number = new ArrayList<Long>();

        // 0 1 2 3 4 5 6 7 8 9
        // 9 8 7 6 5 4 3 2 1 0 10이 최대값
        if(n <= 10){ // n 이 10보다 작으면 그대로 출력
            System.out.println(n);
        }else if(n > 1022) {
            System.out.println(-1);
        }else{
            for (int i = 0; i < 10; ++i) {
                recur(i, 1);
            }
            Collections.sort(number);
            System.out.println(number.get(n));
        }
    }

    public static void recur(long num , int depth){

        if(depth > 10){
            return;
        }

        number.add(num);

        for(int i =0 ; i < 10; ++i){

            if( num % 10 > i ){
                recur( (num*10) +i , depth +1);
            }

        }
    }
}
