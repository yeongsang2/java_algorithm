
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    //상 하 좌 우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static int n;
    static int m;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[][] map = new char[n][m];
        visited = new boolean[n][m];

        int startR =0;
        int startC = 0;
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = str.charAt(j);
                if(c == 'I'){
                    startR = i;
                    startC = j;
                }
                map[i][j] = c;
            }
        }
        search(map, startR, startC);

        if(answer == 0){
            System.out.println("TT");
        }else{
            System.out.println(answer);
        }
    }
    static void search(char[][] map, int r, int c){

        if(map[r][c] == 'P'){
            answer++;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if(isRanged(nextR,nextC) && !visited[nextR][nextC] && map[nextR][nextC] != 'X'){
                visited[nextR][nextC] = true;
                search(map, nextR, nextC);
            }
        }
    }
    static boolean isRanged(int r, int c){
        if(r > -1 && r < n && c >-1 && c < m){
            return true;
        }
        return false;
    }
}
