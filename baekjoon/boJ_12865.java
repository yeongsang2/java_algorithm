package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boJ_12865 {

    public static void main(String[] args) throws IOException {

        int n,k;
        int[][] dp;
        int[][] bag;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); // 물건수
        k = Integer.parseInt(st.nextToken()); // 최대로 들 수 있는 무게수
        dp = new int[n+1][k+1];
        bag = new int[n+1][2];

        for(int i=1 ; i< n+1; i++){
            st = new StringTokenizer(br.readLine());
            bag[i][0] = Integer.parseInt(st.nextToken());
            bag[i][1] = Integer.parseInt(st.nextToken());
        }

        /**
         * 무게당 가치의 합 최대
         * 무게가 1
         *    j 1 2 3 4  5  6  7
         * i
         * 1   0 0 0 0  0  13 13
         * 2   0 0 0 8  8  13 13
         * 3   0 0 6 14 14 14 14
         * 4   0 0 6 14 14 14 14
         *
         * 6 13
         * i <=  j 인경우
         * dp[i][j]
         */
        for(int i =1 ; i< n+1; i++){

            for(int j =1 ; j< k+1; j++){

                if ( bag[i][0] > j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-bag[i][0]]+ bag[i][1]);
                }
            }
        }
        System.out.println(dp[n][k]);





    }
}
