package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.System.exit;

public class boj_2615 {

    public static int[][] map;
    public static boolean[][] visited;
    public static int flag= 0;


    // 우 하 5시 1시
    public static int[] mr = {0,1, 1, -1};
    public static int[] mc = {1,0, 1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[19][19];
        visited = new boolean[19][19];
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <19; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i= 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {

                if(map[i][j] != 0){
                    for(int k =0; k < 4; k++){
                        int nr = i + mr[k];
                        int nc = j + mc[k];
                        if( nr >= 0 && nr <19 && nc>=0 && nc < 19 && map[nr][nc] == map[i][j] ) {
                            dfs(map[i][j], nr, nc, 1,k, i, j);
                        }
                    }

                }

            }
        }
        System.out.println("0");
    }
    // 검정 1, 흰색 2
    public static void dfs(int color, int r, int c, int depth,int direct, int startr, int startc){

        if(depth == 4){
            if( ( r + mr[direct] ) >=0 && (r +mr[direct]) < 19  && ( c + mc[direct] >=0 ) &&  ( c + mc[direct] < 19 )) {
                if ( map[r+mr[direct]][c+ mc[direct]] != color ){
                    System.out.println(map[r][c]);
                    System.out.print(startr + 1 + " ");
                    System.out.print(startc + 1);
                    exit(0);
                    return;
                }
            }else {
                System.out.print(startr + 1 + " ");
                System.out.print(startc + 1);
                exit(0);
            }
        }

        int nr = r + mr[direct];
        int nc = c + mc[direct];
        if( nr >= 0 && nr <19 && nc>=0 && nc < 19 ){
            if( map[nr][nc] == color) {
                dfs(color, nr, nc, depth + 1, direct, startr,startc);
            }
        }
    }
}
