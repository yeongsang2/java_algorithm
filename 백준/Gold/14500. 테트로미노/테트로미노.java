
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited;
    static int[][] board;
    static int[] dr = {-1,1,0,0};
    static int[] dc=  {0,0,-1,1};
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n][m];
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
//                System.out.println(i + ", "  +j);
                search(i,j,0, board[i][j]);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
    }
    static void search(int r, int c, int depth, int sum){

        if(depth == 3){
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if(isRanged(nextR, nextC) && !visited[nextR][nextC]){

                if(depth ==1){
                    visited[nextR][nextC] = true;
                    search(r, c, depth + 1, sum + board[nextR][nextC]);
                    visited[nextR][nextC] = false;
                }

                visited[nextR][nextC] = true;
                search(nextR, nextC, depth + 1, sum + board[nextR][nextC]);
                visited[nextR][nextC] = false;
            }
        }
    }
    static boolean isRanged(int r, int c){
        if(r>= 0 && r < board.length && c>= 0 && c < board[0].length ){
            return true;
        }
        return false;
    }
}
