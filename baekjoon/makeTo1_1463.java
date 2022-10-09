package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class makeTo1_1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min;
        int[] dp = new int[n+1];

        // dp[2] = 1
        // dp[3] = 1
        // dp[4] -> 2로 나누고 2로 나눔 = 2번
        // dp[5] -> 1빼고 2로 나누고 2로 나눔
        // dp[6] -> 3으로 나누고 2로 나눔
        //          2로 나누고 3으로 나눔 2번어쩄든
        // dp[7] -> 1빼고 dp[6]
        // dp[8] -> 2로나누면 4 ->dp[4]

        // dp[10] -> 5 4 2 1  모든 경우의수 해바야할듯
            dp[0] = 0;
            dp[1] = 0;
            for(int i=2 ; i< n+1;i++){
                dp[i] = dp[i-1] +1;
                //3으로 나누어질때
                if(i%3 == 0){
                    dp[i] = Math.min(dp[i/3]+1 ,dp[i]);
                }
                //2로 나누어질떄
                if(i%2 == 0){
                    dp[i] = Math.min(dp[i/2]+1, dp[i]);
                }
            }

        System.out.println(dp[n]);

    }
}
