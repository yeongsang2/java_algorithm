package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class miniShark2_17086 {

    public static int N,M;
    public static int[][] board = new int[51][51];
    public static int[][] visited = new int[51][51];
    public static int max = Integer.MIN_VALUE;
    public static int nowValue;
    // 대각선 4방향(11시, 1시 ,5시, 7시) , 상 하 좌 우
    public static int[] dr = {-1,-1,1,1,-1,1,0,0};
    public static int[] dc = {-1,1,-1,1,0,0,-1,1};
//    public static int[] dr = {-1,1,0,0};
//    public static int[] dc = {0,0,-1,1};


    static class Point{
        public int r;
        public int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0 ; i < N ;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j< M ;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i=0 ; i < N ;i++){
            for(int j=0; j< M ;j++){
                nowValue = 0;
                if(board[i][j] == 0){
                    bfs(i,j);
//                    System.out.println(nowValue);
                    if(nowValue != Integer.MAX_VALUE) {
                        max = Math.max(max, nowValue);
                    }
                }
                initVisit();

            }
        }
        System.out.println(max+1);
    }
    public static void bfs(int r, int c){

        Queue<Point> queue = new LinkedList();
        queue.add(new Point(r,c));

        int min = Integer.MAX_VALUE;

        while(!queue.isEmpty()){

            Point poll = queue.poll();

            for(int i=0; i< 8 ;i++){

                int newR = poll.r + dr[i];
                int newC = poll.c + dc[i];
                if( newR >=0 && newR < N && newC >=0 && newC < M && visited[newR][newC] == 0){ //조건
                    if(board[newR][newC] == 1){
                        min = Math.min(min, visited[poll.r][poll.c]);
                    }else {
                        queue.add(new Point(newR, newC));
                        visited[newR][newC] = visited[poll.r][poll.c] + 1;
                    }
                }
            }
        }
        nowValue = min;

    }
    public static void initVisit(){

        for(int i=0 ; i < N ;i++){
            for(int j=0; j< M ;j++){
                visited[i][j] = 0;
            }
        }
    }
}
