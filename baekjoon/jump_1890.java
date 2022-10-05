package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class jump_1890 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int board[][] = new int[n][n];
        long  dp[][] = new long[n][n];
        boolean visited[][] = new boolean[n][n];

        for(int i = 0 ;i <n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<n;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0]  =1;
        for(int i = 0 ;i <n ; i++){
            for(int j =0;j<n;j++){

                if(board[i][j] == 0){
                    break;
                }
                //오른쪽
                int dc = j + board[i][j];
                if( dc < n ){
                        dp[i][dc] += dp[i][j];
                }
                //아래쪽
                int dr = i + board[i][j];
                if (dr < n){
                        dp[dr][j] += dp[i][j];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);

    }
}
