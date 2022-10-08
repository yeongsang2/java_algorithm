package baekjoon;

import javax.imageio.ImageTranscoder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class sugar_delivery_2839 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1]; // n킬로그램 배달시 봉지 필요한 갯수

        Arrays.fill(dp, 9999);
        dp[3] = 1;
        dp[5] = 1;
        for(int i= 6 ; i <dp.length; i++){
            dp[i] = Math.min(dp[i-3] + 1, dp[i-5] +1);
        }
        if(dp[n] > 9999){
            System.out.println(-1);
        }else{
            System.out.println(dp[n]);
        }


    }
}
