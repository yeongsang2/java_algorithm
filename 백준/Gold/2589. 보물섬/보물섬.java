
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static int n,m;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 'L'){
                    int temp = findMax(map, i, j);
                    answer = Math.max(answer, temp);
                }
            }
        }

        System.out.println(answer);
    }

    static int findMax(char[][] map, int r, int c){

        int[][] visited = new int[n][m];

        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{r,c});

        while (!queue.isEmpty()){

            int[] poll = queue.poll();
            int nowR = poll[0];
            int nowC = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];
                if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m
                    && visited[nextR][nextC] == 0 && map[nextR][nextC] == 'L'){
                    if(nextR == r && nextC == c) continue;
                    visited[nextR][nextC] = visited[nowR][nowC] + 1;
                    queue.add(new int[]{nextR,nextC});
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                System.out.print(visited[i][j]);
                max = Math.max(max, visited[i][j]);
            }
//            System.out.println();
        }
//        System.out.println();

        return max;
    }
}
