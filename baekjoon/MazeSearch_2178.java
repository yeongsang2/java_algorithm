package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class MazeSearch_2178 {

    public static int n,m;
    public static int min = Integer.MAX_VALUE;
    public static int board[][];
    public static int visited[][];
    public static int[] dr = {-1, 1, 0,0}; //상 하 좌 우
    public static int[] dc = {0,0,-1,1};

    public static class Point{
        int r;
        int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return r;
        }

        public void setR(int r) {
            this.r = r;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new int[n][m];

        init();
        for(int i = 0 ; i< n ; i++){
            String str = br.readLine();
            for(int j = 0; j <m; j++){
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        bfs();
        System.out.println(visited[n-1][m-1]+1);
    }

    public static void bfs(){

        Queue<Point> queue= new LinkedList<>();
        queue.add(new Point(0,0));

        while(!queue.isEmpty()){
            Point poll = queue.poll();
            int r = poll.getR();
            int c= poll.getC();
            for(int i =0 ; i<4 ; i++){
                int mr = r + dr[i];
                int mc = c + dc[i];

                if(mr >= 0 && mc >=0 && mr< n && mc <m && board[mr][mc] == 1 && visited[mr][mc] == 0){
                    queue.add(new Point(mr, mc));
                    visited[mr][mc] += visited[r][c] +1;
                }

            }
        }

    }
    public static void init(){
        for(int i = 0 ; i< n ; i++){
            for(int j = 0; j <m; j++){
                visited[i][j] = 0;
            }
        }
    }
}
