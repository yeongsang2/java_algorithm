package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2579 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); //계단 개수
        int[] score = new int[n+1];
        int[] dp = new int[n+1];

        for(int i =1 ; i<n+1 ; i++){
            score[i] = Integer.parseInt(br.readLine());
        }
        // 한 계단 또는 두게단 오를 수 있음
        // 연속된 세 개의 계단 밟을 수 없음 --> 어케하노
        // 시작점은 계단에 포함x
        // 마지막 계단은 반드시 밟아야함

        //  n-3 n-2 n-1 n
        // n-3 n-1 n
        // n-2에서 오거나
        if(n == 1){
            System.out.println(score[1]);
        }else if(n == 2){
            System.out.println(score[1] + score[2]);
        }else {
            dp[0] = 0;
            dp[1] = score[1];
            dp[2] = dp[1] + score[2];
            for (int i = 3; i < n + 1; i++) {
                dp[i] = Math.max(dp[i - 3] + score[i - 1], dp[i - 2]) + score[i];
            }

            System.out.println(dp[n]);
        }
    }
}
