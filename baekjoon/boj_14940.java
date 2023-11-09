package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14940 {

    static int n;
    static int m;
    static int[][] map;
    static int endR;
    static int endC;
    static boolean visited[][];

    //상 하 좌 우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Loc{
        int r;
        int c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1; j++) {
                int now = Integer.parseInt(st.nextToken());
                if(now == 2) {
                    endR = i;
                    endC = j;
                    map[i][j] = 0;
                } else if(now==0){
                    map[i][j] = -1;
                } else{
                    map[i][j] = now;
                }
            }
        }
        bfs(endR, endC);
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int now = map[i][j];
                if(now == -1) {
                    now = 0;
                }else if(!visited[i][j]) {
                    now = -1;
                }
                System.out.print(Integer.toString(now) + ' ');
            }
            System.out.println("");
        }
    }
    static void bfs(int r, int c){
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(r,c));
        visited[r][c] = true;
        while(!queue.isEmpty()){
            Loc now = queue.poll();
            int nowR = now.r;
            int nowC = now.c;
            int nextR;
            int nextC;
            for (int i = 0; i < 4; i++) {
                nextR = nowR + dr[i];
                nextC = nowC + dc[i];
                if( isPossible(nextR,nextC) && !visited[nextR][nextC] && map[nextR][nextC] != -1){
                    map[nextR][nextC] = map[nowR][nowC] +1;
                    visited[nextR][nextC] = true;
                    queue.add(new Loc(nextR,nextC));
                }
            }
        }
    }

    static boolean isPossible(int r, int c){
        if( r >= 1 && r <=n && c>=1 && c<=m){
            return true;
        }
        return false;
    }
}
