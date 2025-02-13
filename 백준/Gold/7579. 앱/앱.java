
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

        int[] A = new int[n];
        int[] B = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            B[i] = num;
            total+= num;
        }

        int[][] dp = new int[n+1][total+1];
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < total + 1; j++) {
                int a = A[i-1];
                int b = B[i-1];
                if(j >= b){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-b] + a);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
                if(dp[i][j] >= m){
                    answer = Math.min(answer, j);
                }
            }
        }

        System.out.println(answer);
    }
}
