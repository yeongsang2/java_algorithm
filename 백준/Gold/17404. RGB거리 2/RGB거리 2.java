
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr =  new int[n][3];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int r =  Integer.parseInt(st.nextToken());
            int g =  Integer.parseInt(st.nextToken());
            int b =  Integer.parseInt(st.nextToken());
            arr[i][0] = r;
            arr[i][1] = g;
            arr[i][2] = b;
        }

        int answerA = search(0, n, arr);
        int answerB = search(1, n, arr);
        int answerC = search(2, n, arr);

        int answer = Math.min( Math.min(answerA, answerB), answerC);
        System.out.println(answer);
    }
    static int search(int choice, int n, int[][] arr){

        int[][] dp = new int[n][3];

        for (int i = 0; i < 3; i++) {
            if(choice == i){
                dp[1][i] = Integer.MAX_VALUE;
            }else{
                dp[1][i] = arr[1][i] + arr[0][choice];
            }
        }

//        dp[1][0] = Integer.MAX_VALUE;
//        dp[1][1] = arr[1][1] + arr[0][choice];
//        dp[1][2] = arr[1][2] + arr[0][choice];

        for (int i = 2; i < n; i++) {
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            if(i == choice) continue;
            answer = Math.min(dp[n-1][i], answer);
        }
        return answer;
    }

}
