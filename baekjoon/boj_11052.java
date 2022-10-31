package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11052 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] p;
        int[] dp = new int[1001];
        int n = Integer.parseInt(br.readLine());
        p = new int[n+1];

        st = new StringTokenizer(br.readLine());

        for(int i =1; i <n+1; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        dp[1] = p[1];
        for(int i =2 ;i <n+1; i++){

        }
        /**
         * 카드팩4개
         * dp[i] -> i개의 카드팩을 구매하기 위한 최대 가격
         * n개의 카드를 구매하는방법
         * 1개의 카드구매 n-1개의 카드구매
         * 2개의 카드 구매 n-2개의 카드구매
         * 3개의 카드 구매 n-3개의 카드구매,,
         *
         */
         for(int i =1 ;i < n+1;i++){
             for(int j = 1 ; j < i+1 ; j++){
                dp[i] = Math.max(dp[i], dp[i-j] + p[j]);
//                 System.out.println("i : " + i + ", j : " + j + ",  " +dp[i]);
             }
         }
        System.out.println(dp[n]);
    }
}
