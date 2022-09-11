package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class pipe_17070_2{


    public static int board[][];
    public static int ans = 0;
    public static int n;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());


        board = new int[n+1][n+1];
        for(int i=1; i <= n ; i++){
            String str = br.readLine();
            st = new StringTokenizer(str);
            for(int j=1; j<=n ; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 머리만 신경써도 되는군,,,

        //초기엔 가로로 놓여있음
        dfs(1,2,0);

        System.out.println(ans);
    }
    // direction 0 가로 1 세로 2 대각선
    public static void dfs(int x, int y, int dir){

        if (x == n & y == n) { //종료조건
            ans++;
            return;
        }


        //가로로 놓여져있고, 조건 만족
        if(dir == 0 ){
            if( y+1 <= n && board[x][y+1] ==  0 ){ //가로로이동
                dfs(x,y+1, 0);
            }
            if( y+1 <=n && x+1 <= n && (board[x][y+1] == 0 && board[x+1][y] == 0 && board[x+1][y+1] == 0)){
                dfs(x+1,y+1, 2); //대각선 이동
            }
        }else if(dir == 1){       //세로로 놓여져 있을때
            if( x+1 <= n && board[x+1][y] == 0){
                dfs(x+1,y,1);
            }
            if( y+1 <=n && x+1 <= n && (board[x][y+1] == 0 && board[x+1][y] == 0 && board[x+1][y+1] == 0)){
                dfs(x+1,y+1,2);
            }
        }else{ // 대각선
            if( y+1 <= n && board[x][y+1] ==  0 ){ //가로로이동
                dfs(x,y+1, 0);
            }
            if( x+1 <= n && board[x+1][y] == 0){
                dfs(x+1,y,1);
            }
            if( y+1 <=n && x+1 <= n && (board[x][y+1] == 0 && board[x+1][y] == 0 && board[x+1][y+1] == 0)){
                dfs(x+1,y+1,2);
            }
        }
    }
}
