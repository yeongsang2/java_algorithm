package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_16926 {

    static int n;
    static int m;
    static int r;
    static int[][] board;

    // 왼 위 우 아래
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static int min;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];

        for (int i = 1; i < n +1 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m +1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        min = Math.min(n,m);

        for (int i = 0; i < r; i++) {
            rotate();
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                System.out.print(Integer.toString(board[i][j]) + ' ');
            }
            System.out.println();
        }
    }
    static boolean checkRange(int r, int c){
        if(r > 0 && r < n+1 && c > 0 && c < m+1)return true;
        return false;

    }
    static void rotate(){
        for (int i = 1; i < min / 2 + 1; i++) {
            int nowR = i;
            int nowC = i;
            int dir = 0;
            int first = board[nowR][nowC];
            while(dir < 4){
                int nextR = nowR + dr[dir];
                int nextC = nowC + dc[dir];

                if(  nextR >= i && nextR <= n - i +1 && nextC >= i && nextC <= m - i + 1 )   {
                    board[nowR][nowC] = board[nextR][nextC];
                    nowR = nextR;
                    nowC = nextC;
                }else {
                    dir++;
                }
            }
            board[nowR+1][nowC] = first;
        }
    }


}
