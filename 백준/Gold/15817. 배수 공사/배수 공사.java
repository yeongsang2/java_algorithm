
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        Integer[] pipeArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pipeArr[i] = l;
            map.put(l, c);
        }

        int[] dp = new int[x+1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int len = pipeArr[i];
            int pipCnt = map.get(len);

            for(int j = x; j >= 0 ; j--){
                for (int k = 1; k <= pipCnt && j - k * len >= 0; k++) {
                    dp[j] = dp[j] + dp[j - k * len];
                }
            }

        }


        System.out.print(dp[x]);

    }
}
