package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2775 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int k, n; // k층
        int[][] dp;
        // n호 -- >몇명 살고 있는지?
        // 1 <=k , n<= 14
        for(int i=0; i <t ;i ++){
            k = Integer.parseInt(br.readLine());
            n = Integer.parseInt(br.readLine());
            dp = new int[k+1][15];
            // 0층에 i호에는 i명
            // a층의 b호에 살려면 a-1의 1호부터 b호 까지 사람들의 수ㅁ까지
            for(int p = 1; p < 15; p++){
                dp[0][p] = p;
            }
            for(int a = 1 ; a <k+1; a++){

                for(int b =1 ; b< n+1; b++){
                    dp[a][b] =  dp[a][b-1] + dp[a-1][b];
                }

            }
            System.out.println(dp[k][n]);
        }

    }
}
