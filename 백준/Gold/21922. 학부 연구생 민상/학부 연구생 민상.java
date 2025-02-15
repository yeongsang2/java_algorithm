
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    static List<int[]> airList = new ArrayList<>();
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if(num == 9){
                    airList.add(new int[]{i,j});
                }
            }
        }
        for(int[] air : airList){
            int r = air[0];
            int c = air[1];
            visited[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int nextR = r + dr[i];
                int nextC = c + dc[i];
                if(isRanged(nextR, nextC)){
                    dfs(nextR, nextC, i);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                System.out.print(visited[i][j] + " ");
                if (visited[i][j]) {
                    answer++;
                }
            }
//            System.out.println();
        }
        System.out.println(answer);
    }
    static void dfs(int r, int c, int dir){
        visited[r][c] = true;
        if(map[r][c] == 9) return;
        int nextR = r;
        int nextC = c;
        if(map[r][c] == 0){
            nextR += dr[dir];
            nextC += dc[dir];
        }else if (map[r][c] == 1 || map[r][c] == 2 || map[r][c] == 3 || map[r][c] ==4 ){

            int stuff = map[r][c];
            // return 하는 경우
            if( (stuff == 1 && dir == 2) || (stuff == 1 && dir == 3) || (stuff == 2 && dir == 0) || stuff == 2 && dir ==1){
                return;
            }
            int changedDir = changeDirection(stuff, dir);
//            if(stuff == 3){
//                System.out.println(r + " " + c);
//                System.out.println(changedDir);
//            }
            nextR += dr[changedDir];
            nextC += dc[changedDir];
            dir = changedDir;
        }
        if(isRanged(nextR, nextC)){
            dfs(nextR, nextC, dir);
        }
    }

    static boolean isRanged(int r, int c){
        if(r >= 0 && r < n && c >= 0 && c < m ){
            return true;
        }
        return false;
    }

    static int changeDirection(int stuff, int dir){
        if(stuff == 3){
            if(dir == 0) return 3;
            if(dir == 1) return 2;
            if(dir == 2) return 1;
            if(dir == 3) return 0;
        }else if(stuff == 1){
            return dir;
        }else if(stuff == 2){
            return dir;
        }
        if(dir == 0) return 2;
        if(dir == 1) return 3;
        if(dir == 2) return 0;
        if(dir == 3) return 1;
        return dir;
    }
}
