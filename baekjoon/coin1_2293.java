package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coin1_2293 {


    private static int result = 0;

    public static void main(String[] args) throws IOException {

        int n,k;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        String str = bf.readLine();
        StringTokenizer st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];
        int[] dp= new int[k+1];

        for(int i=0; i<n ; i++){
            coin[i] = Integer.parseInt(bf.readLine());
        }

        dp[0] =1;
        for(int i =0; i< n; i++){
            for(int j =coin[i] ; j <=k; j++) {
                dp[j] = dp[j] + dp[j - coin[i]];
            }
        }

        System.out.println(dp[k]);


    }
}
