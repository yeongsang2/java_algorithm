package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1010 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        int n,m;
        long dp[][] =new long[31][31];

        for(int i=1 ;i < 31;i++){
            dp[1][i] = i;
        }

        for(int i =0 ; i < t; i++){

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for(int j =2 ; j<n+1; j++){
                for(int k=1; k<m+1; k++){
                    dp[j][k] = dp[j][k-1] + dp[j-1][k-1];
                }
            }

            System.out.println(dp[n][m]);
        }
    }
}
