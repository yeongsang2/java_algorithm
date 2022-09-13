package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MazeSearch_2178 {

    public static int n,m;
    public static int min = Integer.MAX_VALUE;
    public static int board[][];
    public static int visited[][];
    public static int[] dr = {-1, 1, 0,0}; //상 하 좌 우
    public static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visited = new int[n][m];

        init();
        for(int i = 0 ; i< n ; i++){
            String str = br.readLine();
            for(int j = 0; j <m; j++){
                board[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        dfs(0,0 ,1);
        System.out.println(min);
    }

    public static void dfs(int r, int c, int depth){

//        System.out.println(r + " "+ c);
        visited[r][c] = 1; //방ㅁ누처리
        if(r == n-1 && c == m-1){
            // 도착
//            System.out.println("도착");
//            System.out.println(depth);
            min = Math.min(min, depth);
            return;
        }

        for(int i = 0; i<4 ; i++){

            int mr = r + dr[i];
            int mc = c + dc[i];

            if(mr >= 0  && mr < n  && mc >= 0 && mc < m && visited[mr][mc] ==  0 && board[mr][mc] == 1){
                dfs(mr,mc,depth+1);
                visited[mr][mc] = 0;
            }

        }

        return;
    }
    public static void init(){
        for(int i = 0 ; i< n ; i++){
            for(int j = 0; j <m; j++){
                visited[i][j] = 0;
            }
        }
    }
}
