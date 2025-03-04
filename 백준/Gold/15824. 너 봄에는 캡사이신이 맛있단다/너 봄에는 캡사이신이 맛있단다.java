
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long answer = 0;

        long[] pow2 = new long[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i-1] * 2) % MOD;

        }

        for (int i = 0; i < n ; i++) {
            // arr[i]가 최대값인 경우의 수: 2^i - 1
            long maxTerm = (arr[i] * pow2[i]) % MOD;

            // arr[i]가 최소값인 경우의 수: 2^(n-i-1) - 1
            long minTerm = (arr[i] * pow2[n-i-1]) % MOD;

            // 기여도 계산: 최대값 기여 - 최소값 기여
            answer = (answer + maxTerm - minTerm) % MOD;
        }

        if (answer < 0) answer += MOD;

        System.out.println(answer % MOD);

    }
}
