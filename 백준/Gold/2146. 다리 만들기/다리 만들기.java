
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 2;
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] == 1){
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    while (!queue.isEmpty()){
                        int[] poll = queue.poll();
                        int r = poll[0];
                        int c = poll[1];
                        map[r][c] = num;
                        for (int k = 0; k < 4; k++) {
                            int nextR = r + dr[k];
                            int nextC = c + dc[k];
                            if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < n && !visited[nextR][nextC] && map[nextR][nextC] == 1){
                                visited[nextR][nextC] = true;
                                queue.add(new int[]{nextR, nextC});
                            }
                        }
                    }
                    num++;
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(map[i][j] > 1){
                    search(i, j);
                }
            }
        }

        System.out.println(answer);
    }

    static void search(int r, int c){

        Queue<int[]> queue = new LinkedList<>();
        int num = map[r][c];
        boolean[][] checked = new boolean[n][n];
        queue.add(new int[]{r,c,0});
        checked[r][c] = true;

        while (!queue.isEmpty()){

            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];
            int cnt = poll[2];

            if( map[nowX][nowY] != 0 && map[nowX][nowY] != num){
                answer = Math.min(answer, cnt - 1);
            }

            if(cnt > answer) return;

            for (int i = 0; i < 4; i++) {
                int nextR = nowX + dr[i];
                int nextC = nowY + dc[i];

                if(nextR < 0 || nextC < 0|| nextR >= map.length || nextC >= map.length)
                    continue;

                if(map[nextR][nextC] == num) continue;
                if(checked[nextR][nextC]) continue;

                queue.add(new int[] {nextR,nextC,cnt+1});
                checked[nextR][nextC]=true;

            }
        }
    }
}
