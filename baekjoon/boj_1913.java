package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1913 {

    // 상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0,1,0,-1};
    static int n;
    static int t;
    static int ansR;
    static int ansC;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = Integer.parseInt(br.readLine());
        board = new int[n+1][n+1];
        int maxDistance = 1;
        int nowDirection = 0;
        int nowDistance = 0;
        int countChange = 0;

        int nowR = n / 2 +1 ;
        int nowC = n / 2 +1 ;
//        board[nowR][nowC] = 1;

        for (int i = 1; i < n * n + 1; i++) {

            board[nowR][nowC] = i;
            // 최디거리 도달 -> 방향전환 (2번했다? 최대거리늘려
            if (nowDistance == maxDistance){
                nowDistance = 0 ;
                nowDirection =  ( nowDirection + 1 ) % 4 ;
                countChange++;
                if(countChange == 2){
                    countChange =0;
                    maxDistance ++;
                }
            }
            nowR = nowR + dr[nowDirection];
            nowC = nowC + dc[nowDirection];
            nowDistance++;
        }
        draw();
        System.out.println(ansR + " " +  ansC);
        // 방향 전환 두번 할때마다 최대 이동거리 1씩 상승
    }
    public static void draw(){
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1 ; j++) {
                if(t == board[i][j]){
                    ansR = i;
                    ansC = j;
                }
                sb.append(board[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }
}
