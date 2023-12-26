package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17836 {

    static int n;
    static int m;
    static int t;
    static int[][] board;
    static boolean[][] item;
    static boolean[][] visited;
    static int targetR;
    static int targetC;

    // 상 하 좌 우
    static int[] dr = {-1, 1, 0,0};
    static int[] dc = {0,0,-1,1};
    static class Loc{
        int r;
        int c;
        public Loc(int r, int c){
            this.r =r ;
            this.c =c;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken()); // 제한시간
        board = new int[n+1][m+1];
        item = new boolean[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            st= new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2){
                    board[i][j] = 0;
                    item[i][j] = true;
                }else if(board[i][j] == 1){
                    board[i][j] = -1;
                }
            }
        }

        bfs();
    }

    static void bfs(){

        Queue<Loc> queue = new LinkedList<>();

        queue.add(new Loc(1,1));

        int time= 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            Loc loc = queue.poll();
                int nowR = loc.r;
                int nowC = loc.c;
                for (int i = 0; i < 4; i++) {
                    int nextR = nowR + dr[i];
                    int nextC = nowC + dc[i];
                    if (checkRange(nextR, nextC)) {
                        if (item[nowR][nowC]) { //무기 가지고 있음
                            if(board[nextR][nextC] == -1 ){
                                item[nextR][nextC] = true;
                                board[nextR][nextC] = board[nowR][nowC] + 1;
//                                visited[nextR][nextC] = true;
                                queue.add(new Loc(nextR, nextC));
                            }else {
                                if(board[nextR][nextC] >= board[nowR][nowC]){
                                    item[nextR][nextC] = true;
                                    board[nextR][nextC] = board[nowR][nowC] + 1;
//                                    visited[nextR][nextC] = true;
                                    queue.add(new Loc(nextR, nextC));
                                }
                            }

                        } else {
                            if (board[nextR][nextC] == 0) {
                                board[nextR][nextC] = board[nowR][nowC] + 1;
//                                visited[nextR][nextC] = true;
                                queue.add(new Loc(nextR, nextC));
                            }
                        }
                    }
                }
        }

        if(board[n][m] == 0){
            System.out.println("FAIL");
        }else {
            if(board[n][m] > t){
                System.out.println("FAIL");
            }
            System.out.println(board[n][m]);
        }
    }
    static boolean checkRange(int r, int c){
        if(r >= 1 && r <= n && c >=1 && c <=m){
            return true;
        }
        return false;
    }
}
