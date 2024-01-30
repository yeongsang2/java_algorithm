package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18430 {


    static int n;
    static int m;
    static int maxCnt;
    static int answer = Integer.MIN_VALUE;
    static int[][] map;
    static boolean[][] visited;

    static Direction[] directions = new Direction[4];

    static class Direction{
        int dr;
        int dc;
        Direction(int dr, int dc){
            this.dr = dr;
            this.dc = dc;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        maxCnt = (n*m) / 3;

        directions[0] = new Direction(-1, 1);
        directions[1] = new Direction(-1, -1);
        directions[2] = new Direction(1, -1);
        directions[3] = new Direction(1, 1);

        tracking(0,0);

        System.out.println(answer);

    }

    private static void tracking(int idx,int sum) {

        if(idx == n*m){
            answer= Math.max(answer,sum);
            return;
        }
        int r = idx / m;
        int c= idx % m;

        for (int i = 0; i < 4; i++) {
            int nextR = r + directions[i].dr;
            int nextC = c + directions[i].dc;
            if(checkRange(nextR,nextC, r, c)){
                if(!visited[r][c] && !visited[nextR][c] && !visited[r][nextC]){
                    visited[r][c] = true;
                    visited[nextR][c] = true;
                    visited[r][nextC] = true;
                    int temp = (map[r][c]*2) + map[nextR][c] + map[r][nextC];
                    tracking(idx+1,sum+temp);
                    visited[r][c] = false;
                    visited[nextR][c] = false;
                    visited[r][nextC] = false;
                }
            }
        }
        tracking(idx+1,sum);
    }

    private static boolean checkRange(int r, int c, int nextR, int nextC){
        if (r >= 0 && r < n && c >= 0 && c < m && nextR >= 0 && nextR < n && nextC >= 0 && nextC < m) {
            return true;
        }
        return false;
    }
}
