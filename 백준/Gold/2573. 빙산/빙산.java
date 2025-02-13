
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n,m;
    static int[][] map;

    // 상 하 좌 우
    static int[] dr = {-1,1, 0,0};
    static int[] dc = {0,0,-1,1};
    static boolean[][] visited;
    static int cnt;
    static int mountainCnt;
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

        int year = 0;
        while(true){
            year++;
            int[][] minus = new int[n][m];
            cnt = 0;
            mountainCnt = 0;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(map[i][j] >= 1){
                        mountainCnt++;
                        for (int k = 0; k < 4; k++) {
                            int nextR = i + dr[k];
                            int nextC = j + dc[k];
                            if(nextR >= 0 && nextR < n && nextC >=0 && nextC < m && map[nextR][nextC] == 0){
                                minus[i][j]++;
                            }
                        }
                    }
                }
            }

            if(mountainCnt == 0){
//                System.out.println(year);
//                System.out.println("hi");
                System.out.println(0);
                return;
            }

            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = map[i][j] - minus[i][j];
                    if(map[i][j] <= 0){
                        map[i][j] = 0;
                    }else{
                        temp++;
                    }
                }
            }

//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }


//            System.out.println("temp:"  + temp);
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if(flag) break;
                for (int j = 0; j < m; j++) {
                    if(map[i][j] >= 1){
                        flag = true;
                        visited[i][j] = true;
                        search(i,j);
//                        System.out.println("cnt: " + cnt);
                        if(cnt == temp){ //
                            break;
                        }else{
                            System.out.println(year);
                            return;
                        }
                    }
                }
            }
        }
    }

    static void search(int r, int c){

        cnt++;
//        System.out.println(r + " " + c + " value: " + map[r][c]);
        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if(nextR >= 0 && nextR < n && nextC >= 0 && nextC < m
                    && map[nextR][nextC] >= 1 && !visited[nextR][nextC]){
                visited[nextR][nextC] = true;
                search(nextR, nextC);
            }
        }
    }
}
