package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_14712 {

    static int n;
    static int m;

    // 옆 밑 대
    static int[] dr = {0,1,1};
    static int[] dc = {1,0,1};
    static int nemoCnt = 0;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] map;
        int tot = n*m;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map = new int[n][m];
                visited = new boolean[n][m];
                visited[i][j] = true;
                map[i][j] = 1;
                nemo(i,j, map);
                map[i][j] = 0;
                visited[i][j] = false;
            }
        }

        int ans = (int) Math.pow(2,tot);
        System.out.println(ans - nemoCnt);
    }

    public static void nemo(int r, int c,int[][] map){

        System.out.println(r + " " + c);
        if(checkNemo(map)){
//            System.out.println("test");
            nemoCnt++;
        }
        for (int i = r+1; i < n; i++) {
            for (int j = c+1; j < m; j++) {
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    if (map[i][j] == 0) {
                        map[i][j] = 1;
                        nemo(i, j, map);
                    }else {
                        nemo(i, j, map);
                    }
                    visited[i][j] =false;
                }

            }
        }
    }
    static boolean checkNemo(int[][] map){

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                boolean temp = true;

                if(map[i][j] == 1) {
                    for (int k = 0; k < 3; k++) {
                        int nextR = i + dr[k];
                        int nextC = j + dc[k];
                        if(checkRange(nextR,nextC)){
                            if(map[nextR][nextC] == 0){
                                temp = false;
                            }
                        }
                    }
                }

                if(temp){
                    return true;
                }

            }
        }
        return false;
    }
    static boolean checkRange(int r, int c ){
        if(r >= 0 && r<n && c >=0 && c< m){
            return true;
        }
        return false;
    }
}
