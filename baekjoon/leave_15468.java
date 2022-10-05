package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class leave_15468 {

    public static void main(String[] args) throws IOException {

        int N;
        int dp[];
        int T[];
        int P[];
        int max = Integer.MIN_VALUE;

        StringTokenizer st;
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+2];
        T = new int[N+2];
        P = new int[N+2];

        for(int i=1 ; i< N+1; i++){

            st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        //1일차
        // next = 1일차 + T[i];
        // dp[next] = dp[i] + p[i];
        for(int i=1 ; i< N+2; i++) {

            max= Math.max(dp[i], max);

            int next = i + T[i];
            if (next < N + 2) {
                dp[next] = Math.max(dp[next], max + P[i]);
            }
        }
        System.out.println(max);

    }
}
