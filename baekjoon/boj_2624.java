package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_2624 {

    static class Coin{
        int value;
        int cnt;
        public Coin(int value, int cnt){
            this.value = value;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Coin> list = new ArrayList<>();
        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[] dp = new int[t+1];

        for (int i = 0; i < k; i++) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            list.add(new Coin(p, n));
        }
        // 동전 개수 카운팅?

        // 1 5 10
        // 5 - 1* 5/ 5 * 1
        // 10 - 5*2 / 5 * 1 + 1*5 / 10*1
        // 11 - dp[10] + 1 /
        // dp[n] = dp[n] + dp[n- v*c]

        dp[0] = 1;
        for (int i = 0; i < k; i++) {

            Coin coin = list.get(i);
            int value = coin.value;
            int cnt = coin.cnt;
            for (int j = t; j >= 0; j--){
                for (int l = 1; l < cnt+1 && j - value*l >= 0; l++) {
                    dp[j] = dp[j] + dp[j - value*l];
                }
            }
        }
        System.out.println(dp[t]);
    }
}
