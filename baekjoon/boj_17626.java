package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_17626 {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i< 50001 ;i ++){

            int temp = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i ; j++){
                temp = Math.min(temp,dp[i - j*j]);
//                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
            dp[i] = temp +1 ;

        }
        System.out.println(dp[n]);
    }
}// 0 - 0
// 1 - 1
// 2 - 1 1
// 3 - 1 1 1
// 4 - 2
// 5 - 2 1
// 6 - 2 1 1
// 7- 2 1 1 1
// 8 - 2 2
// 9 - 3
// 10 - 3 1
// dp[i] = min(dp[i - j*j] +1