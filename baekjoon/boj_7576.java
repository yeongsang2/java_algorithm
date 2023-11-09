package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_7576 {

    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;
    static class Loc{
        int r;
        int c;
        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static List<Loc> startList;
    static int answer  = -1;
    // 상 하 좌 우
    static int[] dr = {-1, 1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        startList = new LinkedList<>();
        map = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j < m+1 ; j++){
                int now = Integer.parseInt(st.nextToken());
                if (now == 1){
                    now = 0;
                    startList.add(new Loc(i,j));
                }
                map[i][j] = now;
            }
        }

        bfs();
        if(!isNotAllTomato()){
            System.out.println("-1");
        }else {
            int result = -1;
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < m+1; j++) {
                    result = Math.max(result, map[i][j]);
                }
            }
            System.out.println(result);
        }


    }

    static void bfs(){
        Queue<Loc> queue = new LinkedList();
        for(Loc loc : startList){
            queue.add(loc);
            visited[loc.r][loc.c] = true;
        }
        int nextR;
        int nextC;
        Loc nowLoc;
        while(!queue.isEmpty()){
            nowLoc = queue.poll();
            for (int i = 0; i < 4; i++) {
                nextR = nowLoc.r + dr[i];
                nextC = nowLoc.c + dc[i];
                if(checkRange(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] !=-1){
                    queue.add(new Loc(nextR, nextC));
                    map[nextR][nextC] = map[nowLoc.r][nowLoc.c] + 1;
                    visited[nextR][nextC] = true;
                }
            }
        }
//        if(nowLoc == null){
//            System.out.println("-1");
//            System.exit(0);
//        }
//        answer = map[nowLoc.r][nowLoc.c];
    }
    static boolean checkRange(int r, int c){
        if(r >= 1 && r <=n   && c >=1 && c<=m){
            return true;
        }
        return false;
    }
    static boolean isNotAllTomato(){
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(map[i][j] == -1){
                    ;
                }else {
                    if(!visited[i][j]) return false;
                }
            }
        }
        return true;
    }
}
