import java.util.Scanner;

public class boj_15989 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[][] dp = new int[100001][4];
        int[] answer= new int[t+1];

        for(int i =0 ; i< t; i++){
            int n = sc.nextInt();
            dp[1][1] = 1;
            dp[1][2] = 0;
            dp[1][3] = 0;
            dp[2][1] = 1;
            dp[2][2] = 1;
            dp[2][3] = 0;
            dp[3][1] = 1;
            dp[3][2] = 1;
            dp[3][3] = 1;
            // 점화식
            // dp[i][1] = dp[i-1][1]
            // dp[1][2] = dp[i-2][1] + dp[i-2][2]
            // dp[1][3] = do[i-3][1] + dp[i-3][2] + dp[i-3][3]
            for(int j=1; j <4 ;j++){
                for(int k=4; k<n+1; k++){
                    dp[k][1] = dp[k-1][1];
                    dp[k][2]= dp[k-2][1]+ dp[k-2][2];
                    dp[k][3] = dp[k-3][1] + dp[k-3][2] + dp[k-3][3];
                }
            }
            answer[i]  = dp[n][1] + dp[n][2] + dp[n][3];
        }
        for(int i=0; i<t;i++){
            System.out.println(answer[i]);
        }

    }
}
