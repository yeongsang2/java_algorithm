package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class coin2_2294 {
    public static void main(String[] args) throws IOException {
        int n ,k;

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int[] dp = new int[100001];


        String str = bf.readLine();

        StringTokenizer st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] coin = new int[n+1];

        for(int i =1 ;i < n; i++){
            coin[i] = Integer.parseInt(bf.readLine());
        }
        Arrays.fill(dp, Integer.MAX_VALUE-1);
        dp[0] = 0;

        for (int i = 0; i< n; i++){ // 한개 있을댸 두개있을때
            for(int j = coin[i]; j < k+1; j++){
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }

        }
        System.out.println(dp[k]);
    }
}
