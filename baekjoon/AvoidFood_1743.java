package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AvoidFood_1743 {

    public static String board[][];
    public static int visited[][];
    public static int max = Integer.MIN_VALUE;
    public static int cnt;
    public static int n,m,k; // 세로길이, 가로길이, 쓰레기 개수
    public static int[] dr = {-1,1,0,0}; //상 하 좌 우
    public static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new String[n][m];
        visited= new int[n][m];


        for(int i=0;i <n ; i++){ //초기화
            for(int j=0; j<m; j++){
                visited[i][j] =0;
            }
        }


        for(int i=0; i< k; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r-1][c-1] = "#";
        }


        for(int i=0;i <n ; i++){
            for(int j=0; j<m; j++){
                if( board[i][j] == "#" && visited[i][j] == 0){
                    cnt = 0;
                    dfs(i,j);
                    max = Math.max(max,cnt);
                }

            }
        }
        System.out.println(max);

    }
    public static void dfs(int r, int c){

        visited[r][c] = 1;
        cnt++;

        for(int i =0; i<4; i++){

            int mr = r + dr[i];
            int mc = c + dc[i];

            if(mr >= 0 && mc >= 0  && mr < n && mc < m && visited[mr][mc] == 0 && board[mr][mc] == "#"){
                dfs(mr,mc);
            }
        }
    }
}
