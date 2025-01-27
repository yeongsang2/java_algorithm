import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        
        long[] dp = new long[n+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1] + Long.parseLong(st.nextToken());
        }
        
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 1;
        
        while (end <= n) {
            long sum = dp[end] - dp[start];
            
            if (sum >= s) {
                min = Math.min(min, end - start);
                start++;
            } else {
                end++;
            }
        }
        
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}