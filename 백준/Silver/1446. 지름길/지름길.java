
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Load implements Comparable<Load> {
        int start;
        int end;
        int length;

        public Load(int start, int end, int length){
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Load o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        Load[] loads = new Load[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            loads[i] = new Load(start, end ,length);
        }

        Arrays.sort(loads);
        int[] dp = new int[D+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;
        for(Load load : loads){
            int start = load.start;
            int end = load.end;
            int length = load.length;
            for (int i = 1; i < D + 1; i++) {
                if(i == end){
                    dp[i] = Math.min(dp[i], Math.min(dp[i-1] + 1, dp[start] + length));
                }else{
                    dp[i] = Math.min(dp[i], dp[i-1] + 1);
                }
            }
        }

        System.out.println(dp[D]);

    }
}
