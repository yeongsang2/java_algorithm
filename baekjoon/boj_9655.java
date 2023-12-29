package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9655 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n + 1 ];

        // 1 -> 상근             1
        // 2 ( 1 1 ) -> 창영     2
        // 3 ( 3 ) -> 상근       1
        // 4 ( 3 1 ) -> 창       2
        // 5 ( 3 1 1 ) > 상근     3
        // 6 ( 3 3 ) -> 창영      2
        // 7 ( 3 3 1 ) -> 상근    3
        // 8 ( 3 3 1 1 ) -> 창영  4
        // 9  3 3                3

        for (int i = 1; i < n + 1; i++) {
            if( i % 3 == 0){
                dp[i] = i / 3;
            }else{
                int temp = i / 3;
                int rest = i % 3;
                dp[i] = temp+ rest;
            }
        }
        int answer = dp[n];
        if(answer % 2 == 1){
            System.out.println("SK");
        }else {
            System.out.println("CY");
        }

    }
}
