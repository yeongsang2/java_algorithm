package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class rgb_distance_1149 {

    static int n;
    static int[][] cost;
    static int[][] dp;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        // 조건 1번집의 색 != 2번 집의 색
        // n번 집의 색 n-1번 != 집의 색
        // i번 ㅈ비의 색은 i-1번, i+1번 집의 색과 같지 않아야 함
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine()); // 집의 수
        cost = new int[1001][n+1];
        dp = new int[1001][3];

        for(int i=1 ;i< n+1 ;i++){ //1번집부터 시작
            st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[1][0] = cost[1][0];
        dp[1][1] = cost[1][1];
        dp[1][2] = cost[1][2];


        for(int i=2 ; i< n+1; i++){

            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];

        }

        System.out.println(Math.min(Math.min(dp[n][0],dp[n][1]), dp[n][2]));

    }

}
