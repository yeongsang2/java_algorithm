package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class war_1303 {

    public static boolean visited[][];
    public static Character[][] board;

    public static int w = 0;
    public static int b = 0;
    public static int N,M,cnt; // 가로길이 ,세로길이
    public static int[] dx = {-1,1,0,0}; //상하좌우
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new Character[M][N];
        visited = new boolean[M][N];

        for(int i = 0 ; i< M ;i++){
            for(int j =0; j < N; j++){
                visited[i][j] = false;
            }
        }

        for(int i = 0 ; i< M ;i++){
            String str= br.readLine();
            for(int j =0; j < N; j++){
                board[i][j] = str.charAt(j);
            }
        }

        for(int i = 0 ; i< M ;i++){
            for(int j =0; j < N; j++){
                cnt = 0;
                if(visited[i][j] == false){
                    dfs(i,j,board[i][j]);
                    if(board[i][j] == 'W') {
                        w += cnt*cnt;
                    }else{
                        b += cnt*cnt;
                    }
                }
            }
        }
        System.out.println(w + " " + b);
    }
    public static void dfs(int x, int y, Character c){

        visited[x][y] = true;
        cnt++;
        for(int i=0; i< 4; i++){
            int mx = x + dx[i];
            int my = y + dy[i];

            if(mx >= 0 && mx < M && my >= 0 && my < N ){
                if( visited[mx][my] == false && board[mx][my] == c){
                    dfs(mx, my, board[x][y]);
                }
            }
        }

    }
}
