package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coin2_2294 {
    public static void main(String[] args) throws IOException {
        //dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1)
        //dp[0] = 0
        int n ,k;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[100001];

        dp[0] = 0;

        String str = bf.readLine();

        StringTokenizer st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n];

        for(int i = 0; i< n; i++){
            coin[i] = Integer.parseInt(bf.readLine());
        }

        for(int i =1 ; i < k+1 ; i++){
            dp[i] = Integer.MAX_VALUE-1;
        }

        for(int i =0 ; i < n ; i++){ // 1원만있을때 5원만있을때 12원도 있을때,,비교
            for(int j = coin[i]; j <= k ; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }

        if(dp[k] == Integer.MAX_VALUE-1){
            System.out.println(-1);
        }else{
            System.out.println(dp[k]);
        }
    }
}
