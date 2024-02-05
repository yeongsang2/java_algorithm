package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17485 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][m+1];
        for (int i = 1; i < n +1; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 1; j <  m+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long[][][] dp = new long[n+2][m+1][3];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j <  m+1; j++) {

                // 0번 방향에서옴
                if( j+1 < m+1){
                    long a = Math.min(dp[i-1][j+1][1],dp[i-1][j+1][2]);
                    dp[i][j][0] = a + map[i][j];
                }

                // 1번방향
                long b = Math.min(dp[i-1][j][0], dp[i-1][j][2]);
                dp[i][j][1] = b + map[i][j];

                // 2
                if(j-1 > 0) {
                    long c = Math.min(dp[i - 1][j - 1][0], dp[i - 1][j - 1][1]);
                    dp[i][j][2] = c + map[i][j];
                }

            }
        }
        long result = Integer.MAX_VALUE;
        for (int i = 1; i < m+1; i++) {
            for (int j = 0; j < 3; j++) {
                result = Math.min(dp[n][i][j], result);
            }
        }
        System.out.println(result);
    }
}
