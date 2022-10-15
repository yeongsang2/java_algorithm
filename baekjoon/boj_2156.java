package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2156 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] amount = new int[10001];
        int[] dp = new int[10001];
        int result = Integer.MIN_VALUE;

        for(int i=1 ; i<n+1; i++){
            amount[i] = Integer.parseInt(br.readLine());
        }
        // 마신 후 원래 위치에 다시
        //연속으로 놓여있는 3잔 마실 수 없음
        // 직전에 포도주를 마신경우, 직전에 포도주를 마시지 않은 경우, 두잔연속 포도주를 마시지 않은경우
        // 0 - > 직전에 마심
        // 1

        dp[0] = 0;
        dp[1] = amount[1];
        if(n>1) {
            dp[2] = dp[1] + amount[2];
        }

        for(int i =3 ;i <n+1; i++){

            // 직전에 마심
            // 직전에 안마심
            // 두잔 연속 안마심
            dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + amount[i], dp[i-3] + amount[i-1] + amount[i]));

        }
        System.out.println(dp[n]);

    }
}
