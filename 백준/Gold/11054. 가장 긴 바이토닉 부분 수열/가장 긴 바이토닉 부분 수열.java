
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] dp  = new int[n];
        int[] rDp = new int[n];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        dp[0] = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = i-1; j >=0; j--) {
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        rDp[0]=1;
        Arrays.fill(rDp, 1);
        for (int i = n -1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if(arr[j] < arr[i]){
                    rDp[i] = Math.max(rDp[i], rDp[j] + 1);
                }
            }
        }
        int answer = -1;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, dp[i] + rDp[i]);
        }

//        for (int i = 0; i < n; i++) {
//            System.out.print(dp[i] + " ");
//        }
//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            System.out.print(rDp[i] + " ");
//        }

        System.out.println(answer - 1);


    }
}
