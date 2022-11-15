package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_5557 {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] array;
        long[][] dp;
        int n = Integer.parseInt(br.readLine());
        array = new int[n+1];
        dp = new long[n+1][21];
        st = new StringTokenizer(br.readLine());
        for(int i = 1 ;i < n+1; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }

        dp[1][array[1]] = 1;
        for(int i = 2 ; i < n; i++) {
            for (int j = 0; j < 21; j++) {
                    if(dp[i-1][j] !=0){
                        if(j + array[i] <= 20){
                            dp[i][j+array[i]] += dp[i-1][j];
                        }
                        if(j - array[i] >= 0){
                            dp[i][j-array[i]] += dp[i-1][j];
                        }

                }
            }
        }
        System.out.println(dp[n-1][array[n]]);
    }
}
