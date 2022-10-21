package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.exit;

public class boj_1904 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[n + 1];
        /**
         *  0이 홀수 , 0이짝수일경우?
         * 1 또는 00
         *  n==1 일때
         *  dp[1] =1
         *  n==2
         *  dp[2] = 2
         *  00 11
         *  dp[3] 3 홀수일경우 ,,,
         *  100 001  / 111
         *  dp[4] 5
         *  0011, 1001, 1100,/  1111 ,0000
         *  dp[5] 8
         *  10011, 00111, 11001, 11100,/  00001, 00100,  10000, 11111
         *  dp[6]
         *
         * dp[i] = dp[i-1] + 1 + dp[i-2] +2
         */
        if (n == 1) {
            System.out.println(1);
            exit(1);
        }
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 15746;
            }
            System.out.println(dp[n] % 15746);
    }
}