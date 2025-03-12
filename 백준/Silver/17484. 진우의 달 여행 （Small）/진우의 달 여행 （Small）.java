
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] map;
    static int answer = Integer.MAX_VALUE;

    static int[] dr = {1, 1, 1};
    static int[] dc = {-1, 0, 1};
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            search(0, i, -1, map[0][i]);
        }

        System.out.println(answer);
    }

    static void search(int r, int c, int dir, int sum){

        if(r == n - 1) {
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < 3; i++) {

            if(i == dir) continue;;

            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m){
                search(nextR, nextC, i, sum + map[nextR][nextC]);
            }
        }
    }
}
