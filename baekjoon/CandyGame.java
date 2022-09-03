package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyGame {

    public static char[][] board;
    public static int max;
    public static int n;

    public static void checkBoard(){

        // 가로로 비교
        for(int i = 0;i < n;i++){
            int count = 1;
            for(int j = 0; j < n-1;  j++){
                if( board[i][j] ==  board[i][j+1]){
                    count ++;
                }
                else{
                    count = 1;
                }
                max  = Math.max(max, count);
            }
        }

        // 세로로 비교
        for(int i = 0;i < n;i++){
            int count = 1;
            for(int j = 0; j < n-1;  j++){
                if( board[j][i] ==  board[j+1][i]){
                    count ++;
                }
                else{
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char temp;

        board = new char[n][n];

        for(int i = 0; i < n ; i++){
            String s = br.readLine();
            for(int j = 0 ;j <n; j++){
                board[i][j] = s.charAt(j);
            }
        }


        //  swap 전 사탕체크
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j< n-1 ;j++){
                checkBoard();
            }

        }

        // 가로로 비교

        for(int i = 0; i < n; i++){
            for(int j = 0 ; j< n-1 ;j++){
                //swap
                temp = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;

                // 사탕개수 체크
                checkBoard();

                temp = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;

            }

        }

        //세로로 비교
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j< n-1 ;j++){
                //swap
                temp = board[j][i];
                board[j][i] = board[j+1][i];
                board[j+1][i] = temp;

                // 사탕개수 체크
                checkBoard();

                temp = board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1] = temp;

            }
        }

        System.out.println(max);

    }
}
