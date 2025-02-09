
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n+1];

        for(int i = 1 ; i < n + 1 ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int[][] dp = new int[n+1][n+1];

        for(int i = 1; i < n+1 ; i++){
            dp[i][i] = 1;
        }

        for(int i = 1 ; i < n ; i++){
            if(arr[i] == arr[i+1]) {
                dp[i][i+1] = 1;
            }
        }

        for(int i = 2 ; i < n ; i++){
            for(int j = 1; j <= n - i ; j++){
                if(arr[j] == arr[j + i] && dp[j + 1][j + i - 1] == 1){
                    dp[j][j+i] = 1;
                }
            }
        }
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(dp[a][b]);
            sb.append("\n");
//            System.out.println(dp[a][b]);
        }
        System.out.println(sb.toString());
    }
}
