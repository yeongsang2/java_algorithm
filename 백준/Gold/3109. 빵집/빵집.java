import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int R, C;
    static char[][] map;
    static boolean[][] checked;
    static int answer = 0;


    // 오위, 오, 오아
    static int[] dr = {-1, 0, 1};
    static int[] dc = {1, 1, 1};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        checked = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            if(dfs(i, 0)){
                answer++;
            }
        }
        // 크로스 안됨
        // 곂치면 안됨
        System.out.println(answer);
    }
    static boolean dfs(int r, int c){

        if(c == C - 1){
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if(nextR >= 0 && nextR < R && c < C && !checked[nextR][nextC] && map[nextR][nextC] == '.'){
                checked[nextR][nextC] = true;
                if(dfs(nextR, nextC)){
                    return true;
                }
            }
        }

        return false;
    }
}
