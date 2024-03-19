package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11053 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int max = Integer.MIN_VALUE;
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[10001];
        int[] dp = new int[1001];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<n+1; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = 1;
        for(int i =2 ; i< n+1 ;i++){

            for(int j = i-1; j >= 0 ; j--){
                if(array[i] > array[j]){ //증가
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i] +=1;
        }

        for(int i =1 ; i< dp.length; i++){
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
