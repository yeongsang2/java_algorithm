package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_1210 {

    static int[][] board;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=  new StringBuilder();

        for (int i = 1; i < 11 ; i++) {
            int t = Integer.parseInt(br.readLine());
            board = new int[100][100];
            int startC =0;
            for (int j = 0; j < 100; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < 100; k++) {
                    int now = Integer.parseInt(st.nextToken());
                    board[j][k] = now;
                    if(now == 2){
                        startC = k;
                    }
                }
            }
            search(99,startC, 0);
            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void search(int r, int c, int dir){ // -0이면 올라가고 1이면 왼족 2면 오른쪽
        if(r == 0){
            answer = c;
            return;
        }
        if(dir == 0){ //올라가는즁;
            if( c < 99 &&  board[r][c+1] == 1){ //오른쪽 꺾
                dir = 2;
                c++;
            } else if( c > 0 && board[r][c-1] == 1){ //왼꺾
                dir = 1;
                c--;
            }else{
                r--;
            }
        }else if (dir == 1){ //왼
            if( c > 0 && board[r][c-1] == 0){ //
                dir = 0;
                r--;
            }else if( c == 0 ) {
                dir = 0;
                r--;
            }else{
                c--;
            }
        }else { //오
            if( c < 99 && board[r][c+1] == 0){
                dir = 0;
                r--;
            }else if ( c == 99){
                dir = 0;
                r--;
            }else{
                c++;
            }
        }
        search(r,c,dir);
    }
}
