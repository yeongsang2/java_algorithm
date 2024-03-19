package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9095 {

    public static void main(String[] args) throws IOException {
        int t;
        int n;
        int[] answer;
        int[][] dp = new int[100001][4];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        answer = new int[t+1];
        for(int k=0; k< t ;k++){
            n = Integer.parseInt(br.readLine());
            /**
             * dp[1] = 1
             * dp[2] = 2
             * 1 1 / 2
             * dp[3] =
             * 1 1 1 / 1 2 / 2 1 / 3
             *
             * dp[i][j] i를 만드는데 j로 끝난다?
             * dp[1][1] = 1
             * dp[1][2] = 0
             * dp[1][3] = 0
             *
             * dp[2][1] = 1
             * dp[2][2] = 1
             * dp[2][3] = 0
             *
             * dp[3][1] = 2 / 1 1 1 , 2 1
             * dp[3][2] = 1 / 1 2
             * dp[3][3] = 1 / 0 3
             *
             * dp[4][1] =  4   / 1 1 1 1 , 2 1 1 , 1 2 1,  3 1
             * dp[4][2] =  2   / 2 2,  1 1 2
             * dp[4][3] =  1   / 1 3
             *
             * dp[i][1] = dp[i-1][1] + dp[i-1][2] + dp[i-1][3]
             * dp[i][2] = dp[i-2][1] + dp[i-2][2] + dp[i-3][3]
             * dp[i][3] =
             *
             *
             * dp[i][1] = dp[i-1][1] + dp[i-1][2] + dp[i-1][3]
             *              3             1            1
             * dp[i][2] = dp[i-2][1] + dp[i-2][2] + dp[i-2][3]
             *             1             1             0
             * dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3]
             *               1
             */
            if(n == 1){
                answer[k] = 1;
            } else if (n == 2) {
                answer[k] = 2;
            } else if(n == 3){
                answer[k] = 4;
            }else{
                dp[1][1] = 1;
                dp[1][2] = 0;
                dp[1][3] = 0;

                dp[2][1] = 1;
                dp[2][2] = 1;
                dp[2][3] = 0;

                dp[3][1] = 2;
                dp[3][2] = 1;
                dp[3][3] = 1;

                for(int i =4 ;i < n+ 1; i++){
                    dp[i][1] = dp[i-1][1] + dp[i-1][2] + dp[i-1][3];
                    dp[i][2] = dp[i-2][1] + dp[i-2][2] + dp[i-2][3];
                    dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
                }
                answer[k] = dp[n][1] + dp[n][2] + dp[n][3];
            }
        }
        for(int i=0; i< t; i++){
            System.out.println(answer[i]);
        }

    }
}
