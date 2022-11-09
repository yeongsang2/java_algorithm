package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class boj_11057 {

    public static void main(String[] args) throws IOException {

        /**
         * n == 1
         * dp[1][0]
         * 0 1 2 3 4 5 6 7 8 9
         *
         * n == 2
         * dp[2]
         * 00
         * 01 11
         * 02 12 22
         * 03 13 23 33
         * ..
         * 09 19 ,,,, ,, 99
         *
         * dp[i][j]  j번째로 끝나는 수
         * dp[2][0] = 1
         * dp[2][1] = 2
         * dp[2][2] = 3
         * ..
         * dp[2][9] = 10
         *
         * n == 3
         * d[3]
         * 000
         *
         * 001 011 111
         *
         * 002 012 112 022 122 222
         *
         * 222 223 224 225 226 227 228 229
         *
         *
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        int result = 0;
        if (n == 1) {
            System.out.println(10);
        } else
        {
            for (int i = 0; i < 10; i++) {
                dp[1][i] = 1;
            }
            for (int i = 2; i < n + 1; i++) {
                for (int j = 0; j < 10; j++) {
                    for(int k = 0 ; k < j+1 ;k++){
                        dp[i][j] += ((dp[i-1][k])%10007);
                    }
                }
            }
            System.out.println(Arrays.stream(dp[n]).sum() % 10007);
        }
    }
}
