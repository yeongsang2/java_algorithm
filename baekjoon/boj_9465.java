package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465 {

    public static void main(String[] args) throws IOException {

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i =0 ; i< t;i++){

            int n = Integer.parseInt(br.readLine());

            int[][] stick = new int[3][n+1];
            int[][] dp = new int[n+1][3];

            for(int j = 1 ; j< 3;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=1 ; k <n+1; k++){
                    stick[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            /**
             * dp[i][0] 첫행선택
             * dp[i][1] 두번째행선택
             * dp[i][2] 둘다선택x
             *
             * dp[i][0] = Math.max(dp[i-1][1] + stick[i], dp[i-1][2] + stick[i])
             * dp[i][1] = Math.max(dp[i-1][0] + stick[i], dp[i-1][2] + stick[i])
             * dp[i][2] = Math.max(dp[i-1][0], dp[i-1][1])
             */

            dp[1][0] = stick[1][1];
            dp[1][1] = stick[2][1]; // 1의1이아니고 2의1이지병신아

            dp[1][2] = 0;

                for(int k = 2; k < n+1; k++){

                    dp[k][0] = Math.max(dp[k-1][1] + stick[1][k], dp[k-1][2] + stick[1][k]);
                    dp[k][1] = Math.max(dp[k-1][0] + stick[2][k], dp[k-1][2] + stick[2][k]);
                    dp[k][2] = Math.max(dp[k-1][0], Math.max(dp[k-1][1], dp[k-1][2]));
                }
            System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));
        }

    }
}
