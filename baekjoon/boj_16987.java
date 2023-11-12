package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16987 {
    static int n;
    static int[][] board;
    static int[] visited;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][2];
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken()); //내구도
            board[i][1] = Integer.parseInt(st.nextToken()); //무게
        }

        search(0);

        System.out.println(answer);
    }

    static void search(int now){

//        if( now == n || checkPossible(now)){
        if( now == n || checkPossible(now)){
            int cnt =0 ;
            // 내구도 0이하면
            for (int i = 0; i < n; i++) {
                if(board[i][0] <= 0){
                    cnt++;
                }
            }
            answer = Math.max(answer,cnt);
            return;
        }

        if(board[now][0] <= 0){
            search(now+1);
            return;
        }

        //일딴 뿌셔

        for (int i = 0; i < n; i++) {

            if(i==now){
                ;
            }else {
                if (board[i][0] > 0) {
                    board[i][0] -= board[now][1];
                    board[now][0] -= board[i][1];
                    search(now + 1);
                    board[i][0] += board[now][1];
                    board[now][0] += board[i][1];
                }
            }
        }
    }
    static boolean checkPossible(int possible){
        for (int i = 0; i < n; i++) {
            if(i == possible) continue;
            if(board[i][0] > 0) return false;
        }
        return true;
    }
}
