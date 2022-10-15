package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2193 {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n+1][2];
        // 0으로 시작x
        // 1이 두번 연속 나타나지 않음, -> 11x
        /**
         * n자리 이친수
         * n == 1
         * 1
         * n == 2
         * 10
         * dp[2][0] = 10
         * n == 3
         * 101
         * 100
         * n == 4
         * 1010
         * 1000
         * 1001
         *
         */
        // dp[i][0] = dp[i-1][0] + d[i-1]
        // dp[i][1] = dp[i-1][0]
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i =2 ; i<n+1; i++){
             dp[i][0] = dp[i-1][0] + dp[i-1][1];
             dp[i][1] = dp[i-1][0];
        }
        System.out.println(dp[n][0] + dp[n][1]);
    }
}
