package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 1 <= n <= 1000;
        // 2 * n 크기의 직사각형을
        // 1*2, 2*1 타일로 채우는 방법의 수
        if( n == 1){
            System.out.println(1);
        }else if(n ==2){
            System.out.println(2);
        }else {
            int[] dp = new int[1001];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i < n + 1; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
            }
            System.out.println(dp[n]);
        }
    }
}
