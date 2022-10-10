package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class fib_func_1003 {

    public static int cntOne, cntZero;

    public static void main(String[] args) throws IOException {

        // 0이 출력되는 회수와 1이 출력되는 횟수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i =0 ; i< t ;i ++){
            int n = Integer.parseInt(br.readLine()); // 0 or 1 <40;
            cntOne = 0;
            cntZero = 0;
            fib(n);
            System.out.println(cntZero + " " + cntOne);
        }
    }

    public static void fib(int n){
//        if(n==0){
//            cntZero++;
//            return 0;
//        }else if(n==1){
//            cntOne++;
//            return  1;
//        }else
//            return fib(n-1) + fib(n-2);
        int[][] dp = new int[41][2];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[1][0] = 0;
        dp[1][1] = 1;
        for(int i = 2 ; i< n+1 ;i ++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0] + dp[i-1][1];
        }
        cntZero = dp[n][0];
        cntOne = dp[n][1];
    }
}
