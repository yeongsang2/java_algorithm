import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m,r;
    static int answer = 0;
    static int[][] map;
    static char[][] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[n + 1][m + 1];
        visited = new char[n + 1][m + 1];
        
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1 ; j < m + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                visited[i][j] = 'S';
            }
        }

        while(r-- > 0){
            st = new StringTokenizer(br.readLine());
            // offense
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            int height = map[r][c];
            cnt = 0;
            if(visited[r][c] == 'S'){
                visited[r][c] = 'F';
                dfs(r, c, height, dir);
            }
            answer += cnt;
            // defense
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            visited[r][c] = 'S';
        }
        System.out.println(answer);
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }

    }
    static void dfs(int r, int c, int height, String dir){

        cnt++;
//        System.out.println("좌표: " + r + " " + c);
        // 동 서 남 북
        if(dir.equals("E")){
            for (int i = c + 1; i < c + height ; i++) {
                if(i > m) break;
                if(visited[r][i] == 'S'){
                    visited[r][i] = 'F';
                    dfs(r, i, map[r][i], dir);
                }
            }
        }else if(dir.equals("W")){
            for (int i = c - 1; i > c - height ; i--) {
                if(i < 1) break;
                if(visited[r][i] == 'S') {
                    visited[r][i] = 'F';
                    dfs(r, i, map[r][i], dir);
                }
            }
        }else if(dir.equals("S")){
            for (int i = r + 1; i < r + height ; i++) {
                if(i > n) break;
                if(visited[i][c] == 'S'){
                    visited[i][c] = 'F';
                    dfs(i, c, map[i][c], dir);
                }
            }
        }else{
            for (int i = r - 1; i > r - height ; i--) {
                if(i < 1) break;
                if(visited[i][c] == 'S'){
                    visited[i][c] = 'F';
                    dfs(i, c, map[i][c], dir);
                }
            }
        }
    }
}
