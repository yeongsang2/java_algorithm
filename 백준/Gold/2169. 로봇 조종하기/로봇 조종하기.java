
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int n,m;
    static int[][] dp;
    // 아, 왼, 오
    static int[] dr = {1, 0, 0};
    static int[] dc = {0, -1, 1};
    static boolean[][] checked;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 첫줄은 왼쪽에서만옴
        dp[0][0] = map[0][0];
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i-1] + map[0][i];
        }

        for (int i = 1; i < n; i++) {
            
            int[] left = new int[m];
            int[] right = new int[m];

            left[0] = dp[i-1][0] + map[i][0];

            // 왼 -> 오
            for (int j = 1 ; j < m ; j++){
                left[j] = Math.max(left[j-1], dp[i-1][j])  + map[i][j];
            }

            // 오 -> 왼
            right[m-1] = dp[i-1][m-1] + map[i][m-1];
            for (int j = m - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], dp[i-1][j]) + map[i][j];
            }

            for (int j = 0; j < m; j++) {
                dp[i][j] = Math.max(left[j], right[j]);
            }
        }

        System.out.println(dp[n-1][m-1]);
    }
}
