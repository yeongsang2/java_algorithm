package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); //삼각형 크기

        int[][] graph = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        int max = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0; j <i+1;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = graph[0][0];

        for(int i=1;i<n;i++){
            for(int j=0; j <i+1;j++) {
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + graph[i][j];
                }else if(j == i){
                    dp[i][j] = dp[i-1][j-1] + graph[i][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + graph[i][j];
                }
            }
        }

        for(int i=0;i<n;i++){
            max = Math.max(max, dp[n-1][i]);
        }

        System.out.println(max);


    }
}
