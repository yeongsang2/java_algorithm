package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.exit;
import static java.lang.System.in;

public class boj_2615 {

    public static int[][] map;
    public static boolean[][] visited;
    public static int flag= 0;


    // 우 5시 하 7시
    public static int[] dr = {0, 1, 1, 1};
    public static int[] dc = {1, 1, 0, -1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[20][20];
        visited = new boolean[20][20];

        for (int i = 1; i < 20 ; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < 20; i++) {
            for (int j = 1; j < 20; j++) {
                if( (map[i][j] == 1) || map[i][j] == 2){
                    for (int k = 0; k <4; k++) {
                        int nowR = i + dr[k];
                        int nowC = j + dc[k];
                        if(checkRange(nowR, nowC)){
                            if ( (map[nowR][nowC] == map[i][j]) && (!visited[i][j]) )  {
                                dfs(i, j, map[i][j], 1, k, i, j);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(0);
        
    }

    static void dfs(int r, int c, int color, int count, int dir, int startR, int startC ){

        if(count == 5){
            int nowR = r +dr[dir];
            int nowC = c +dc [dir];
            if(checkRange(nowR, nowC)){
                if(map[nowR][nowC] == color){
                    while(checkRange(startR, startC)){
                        if(map[startR][startC] == color){
                            visited[startR][startC] = true;
                            startR = startR + dr[dir];
                            startC = startC + dc[dir];
                        }
                    }
                }
            }else {
                if(dir == 3){
                    System.out.println(map[r][c]);
                    System.out.print(Integer.toString(startR +4 )+ ' ' + Integer.toString(startC  -4));
                    exit(0);

                }
                System.out.println(map[r][c]);
                System.out.print(Integer.toString(startR)+ ' ' + Integer.toString(startC));
                exit(0);
            }
        }

        int nowR= r + dr[dir];
        int nowC =c + dc[dir];
        if (checkRange(nowR, nowC)){
            if (map[nowR][nowC] == color && (!visited[nowR][nowC])){
                dfs(nowR,nowC, color, count+1, dir, startR, startC);
            }
        }

    }
    static boolean checkRange(int r, int c){
        if( r > 0 && r <20 && c > 0 && c<20) {
            return true;
        }
        return false;
    }

}
