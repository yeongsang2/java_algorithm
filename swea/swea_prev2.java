package swea;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class swea_prev2 {

    static int n;
    static int[][] arr;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 1; i <= t; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n][3];
            dp = new int[n][8];

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
                arr[j][2] = Integer.parseInt(st.nextToken());
                Arrays.fill(dp[j], -1);
            }

            if (n < 3) {
                sb.append("#" + i + " " + -1).append("\n");
                continue;
            }

            int answer = minCost(0, 0);
            sb.append("#" + i + " " + answer).append("\n");
        }
        System.out.println(sb.toString());
    }

    static int minCost(int idx, int mask) {
        if (idx == n) {
            for (int i = 0; i < 3; i++) {
                if ((mask & (1 << i)) == 0) {
                    return Integer.MAX_VALUE;
                }
            }
            return 0;
        }

        if (dp[idx][mask] != -1) {
            return dp[idx][mask];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            int nextMask = mask | (1 << i);
            int tempTotal = 0;

            for (int j = 0; j < 3; j++) {
                if (j == i) {
                    continue;
                }
                tempTotal += arr[idx][j];
            }

            int subproblem = minCost(idx + 1, nextMask);
            if (subproblem != Integer.MAX_VALUE) {
                min = Math.min(min, tempTotal + subproblem);
            }
        }

        return dp[idx][mask] = min;
    }
}
