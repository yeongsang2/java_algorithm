import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .toArray();

        int n = input.length - 1; // 마지막 0을 제외
        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[][][] dp = new int[5][5][Math.max(1, n + 1)]; // 왼발, 오른발, 순서

        // DP 배열 초기화
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE / 2);
            }
        }
        dp[0][0][0] = 0;

        // DP 계산
        for (int idx = 1; idx <= n; idx++) {
            int op = input[idx - 1];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (dp[i][j][idx - 1] != Integer.MAX_VALUE / 2) {
                        // 왼쪽 발 사용
                        dp[op][j][idx] = Math.min(dp[op][j][idx], dp[i][j][idx - 1] + moveCost(i, op));
                        // 오른쪽 발 사용
                        dp[i][op][idx] = Math.min(dp[i][op][idx], dp[i][j][idx - 1] + moveCost(j, op));
                    }
                }
            }
        }

        // 최소 힘 찾기
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                answer = Math.min(answer, dp[i][j][n]);
            }
        }
        System.out.println(answer);
    }

    static int moveCost(int from, int to) {
        if (from == to) return 1; // 같은 지점 반복
        if (from == 0) return 2; // 중앙에서 움직이는 경우

        // 인접 이동 (예: 1 ↔ 2, 2 ↔ 3 등)
        if (Math.abs(from - to) == 1 || Math.abs(from - to) == 3) return 3;

        return 4; // 반대편 이동 (예: 1 ↔ 3, 2 ↔ 4)
    }
}
