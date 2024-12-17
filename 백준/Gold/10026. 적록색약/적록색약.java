
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static class Point{
        int r;
        int c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static char[][] board;
    static boolean[][] visited;

    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[n][n];

        int answerA = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    answerA++;
                    visited[i][j] = true;
                    bfsNormal(i,j);
                }
            }
        }

        visited = new boolean[n][n];

        int answerB = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    answerB++;
                    visited[i][j] = true;
                    bfs(i,j);
                }
            }
        }
        System.out.println(answerA + " " + answerB);
    }
    static void bfsNormal(int r, int c){

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));

        while(!queue.isEmpty()){
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = poll.r + dr[i];
                int nextC = poll.c + dc[i];
                if(isRanged(nextR, nextC) && !visited[nextR][nextC]){
                    if(board[poll.r][poll.c] == board[nextR][nextC]){
                        visited[nextR][nextC] = true;
                        queue.add(new Point(nextR, nextC));
                    }
                }
            }

        }
    }

    static void bfs(int r, int c){

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));

        while(!queue.isEmpty()){
            Point poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = poll.r + dr[i];
                int nextC = poll.c + dc[i];
                if(isRanged(nextR, nextC) && !visited[nextR][nextC]){

                    // red 또는 green인 경우
                    if(board[poll.r][poll.c] == 'R' || board[poll.r][poll.c] == 'G'){
                        if(board[nextR][nextC] == 'R' || board[nextR][nextC] == 'G'){
                            visited[nextR][nextC] = true;
                            queue.add(new Point(nextR, nextC));
                        }
                    }else {
                        if (board[poll.r][poll.c] == board[nextR][nextC]) {
                            visited[nextR][nextC] = true;
                            queue.add(new Point(nextR, nextC));
                        }
                    }
                }
            }

        }
    }
    static boolean isRanged(int r, int c){
        if(r >= 0 && r < board.length && c >=0 && c < board.length){
            return true;
        }
        return false;
    }
}
