package baekjoon;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2877 {

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] dp = new int[k+1];

//        dp[0] = 0;
        dp[1] = 4;
        dp[2] = 7;
        int point = 0;
//        boolean flag= true;
        for (int i = 1; i < k+1; i++) {

            if (i % 2 == 1) {
                dp[i] = dp[point] * 10 + 4;
            } else {
                dp[i] = dp[point] * 10 + 7;
                point++;
            }
        }
        System.out.println(dp[k]);
//        4 7 / 44 47 / 74 77 / 444 447 / 474 477 / 744 777 / 4444 4447 /
    }
}
