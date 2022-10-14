package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1912 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[100001];
        int[] dp = new int[100001];
        int max = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = array[1];

        for(int i=2; i<n+1; i++){
            if( dp[i-1] < 0) {
                dp[i] = array[i];
            }else {
                dp[i] = dp[i - 1] + array[i];
            }
        }
        for(int i=1; i<n+1;i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
