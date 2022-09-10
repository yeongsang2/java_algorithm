package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pipe_17070 {


    // 이동                   우 밑 대각선
    public static int dr[] = {0,1,1};
    public static int dc[] = {1,0,1};

    public static int board[][];
    public static int result = 0;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int tailX= 0; //왼쪽 좌표
        int tailY = 0;

        int headX = 1;
        int headY = 0;
        board = new int[n][n];
        for(int i=0; i < n ; i++){
            String str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=0; j<n ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //초기엔 가로로 놓여있음
        // 우측으로
        dfs(0, 1 ,1 ,0);
        // 대각선으로 출바알
        dfs(0,1, 1,1);

        System.out.println(result);
    }

    public static void dfs(int tailX ,int tailY, int headX, int headY) {

        if (headX == n - 1 && headY == n - 1) { // head x,y모두 n,n 에 도착
            result++;
        }
        //끝이여도 못감
        if (headX == n || headY == n) {
            return;
        }
        //벽에 막히면 갈 수 없긩
            //가로로 누워져있을때
            if (tailX == headX) {
                //우측으로
                if (board[headX][headY + 1] == 0 && headY+1 < n-1) {
                    dfs(tailX, tailY + 1, headX, headY + 1);
                }
                //대각선으로
                if (board[headX + 1][headY + 1] == 0 && board[headX + 1][headY] == 0 && board[headX][headY + 1] == 0 && (headY+1 < n-1 && headX +1 < n-1) ) {
                    dfs(tailX, tailY + 1, headX + 1, headY + 1);
                }
            } else if (tailY == headY) {//세로로 누워져있을때

                //아래로
                if (board[headX + 1][headY] == 0 && headX + 1 < n-1) {
                    dfs(tailX + 1, tailY, headX + 1, headY);
                }
                //대각선으로
                if (board[headX + 1][headY + 1] == 0 && board[headX + 1][headY] == 0 && board[headX][headY + 1] == 0 && (headY+1 < n-1 && headX +1 < n-1)) {
                    dfs(tailX + 1, tailY, headX + 1, headY + 1);
                }

            } else {//대각선일때

                //우측
                if (board[headX][headY + 1] == 0 && headY+1 < n-1) {
                    dfs(tailX + 1, tailY + 1, headX, headY + 1);
                }
                //세로
                if (board[headX + 1][headY] == 0 && headX+1 < n-1) {
                    dfs(tailX + 1, tailY + 1, headX + 1, headY);
                }
                //대각선
                if (board[headX + 1][headY + 1] == 0 && board[headX + 1][headY] == 0 && board[headX][headY + 1] == 0 && (headY+1 < n-1 && headX +1 < n-1)) {
                    dfs(tailX + 1, tailY + 1, headX + 1, headY + 1);
                }
            }
    }
}
