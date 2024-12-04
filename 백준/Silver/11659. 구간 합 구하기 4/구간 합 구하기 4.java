
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp =  new int[n+1];
        dp[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            int number = Integer.parseInt(st.nextToken());
            dp[i] = dp[i-1] + number;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(dp[b] - dp[a-1]);
        }
        // 0 1 2 3  4  5
        // 0 1 3 6 10 15
    }
}
