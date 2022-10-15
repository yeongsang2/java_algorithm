package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10844 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[101][10];
        long result = 0;
        long mod = 1_000_000_000;

        // 길이가 n인 계단수가 총 몇개
        /**
         * n == 1 ?
         * dp[1][0] = 0 ;
         * dp[1][1] = 1;
         * dp[1][2] = 2;
         * n == 2 ?
         * 1,2,3,4,5,6,7,8,9  ==> 9개
         *
         * n == 2
         * dp[2][0] 10          1
         * dp[2][1] 21          1
         * dp[2][2] 32 12      14
         * dp[2][3] 43 23
         * dp[2][4] 54 34
         * 5
         * 6
         * 7
         * 8        78 98
         * ,,
         * dp[2][9] 89        1
         *
         * n == 3 3자리인데 j으로 끝나는
         * dp[3][0] 210
         * dp[3][1] 121, 321, 101
         * dp[3][2] 232, 432, 212
         * dp[3][3] 123 323, 343, 543
         * dp[3][4] 434, 234, 454, 654
         * ,,,
         * dp[3][9]  789  989
         *
         * n == 4

         */
        dp[1][0] = 0;
        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }
        //dp[i][0] ~dp[i][9] i자리 0부터 9
        if (n >= 2) {

                for (int i = 2; i < n + 1; i++) {
                    for (int j = 0; j < 10; j++) {
                        if(j == 0){
                            dp[i][j] = (dp[i - 1][j + 1]) % mod;
                        }else if (j == 9){
                            dp[i][j] = (dp[i - 1][j - 1]) % mod;
                        }else {
                            dp[i][j] = ((dp[i - 1][j - 1] ) + (dp[i - 1][j + 1])) % mod;
                        }

                    }
                }
        }
         for(int i=0; i<10; i++) {
             result += dp[n][i];
         }
         System.out.println(result % mod);
    }
}
