package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2806 {

    static int n;
    static int checked[][];
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int k = 1; k < t+1 ; k++) {
            n = Integer.parseInt(br.readLine());
            answer = 0;
            checked = new int[n+1][n+1];
            // 같은 행, 열, 대각선 위에 둘 이상의 말이 있음 안됨

            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1 ; j++) {
                        check(i,j);
                        dfs(i,j,1);
                        unCheck(i,j);
                    }
            }
            System.out.println("#" + Integer.toString(k) + " "+ Integer.toString(answer));
        }
    }

    static void dfs(int r, int c, int cnt){

        if(cnt == n){
            answer++;
            return;
        }

        for (int i = r; i < n+1; i++) {
            for (int j = 1; j < n+1 ; j++) {
                if(checked[i][j] == 0){
                    check(i,j);
                    dfs(i,j,cnt+1);
                    unCheck(i,j);
                }
            }
        }
    }
    static void check(int r, int c){

        //행 check
        for (int i = 1; i < n+1; i++) {
            checked[r][i] += 1;
        }
        //열 check
        for (int i = 1; i < n+1; i++) {
            checked[i][c] += 1;
        }

        // 11시 1 시 5시 7시
        int[] dr = {-1,-1,1,1};
        int[] dc = {-1,1,1,-1};
        //대각 check
        for (int i = 0; i < 4; i++) {

            int nowR;
            int nowC;
            nowR = r+ dr[i];
            nowC = c+ dc[i];
            while(isPossible(nowR, nowC)){
                checked[nowR][nowC] +=1;
                nowR = nowR+ dr[i];
                nowC = nowC+ dc[i];
            }
        }
    }

    static void unCheck(int r, int c){

        //행 check
        for (int i = 1; i < n+1; i++) {
            checked[r][i] -= 1;
        }
        //열 check
        for (int i = 1; i < n+1; i++) {
            checked[i][c] -= 1;
        }

        // 11시 1 시 5시 7시
        int[] dr = {-1,1,-1,1};
        int[] dc = {-1,-1,1,1};
        //대각 check
        for (int i = 0; i < 4; i++) {

            int nowR;
            int nowC;
            nowR = r+ dr[i];
            nowC = c+ dc[i];
            while(isPossible(nowR, nowC)){
                checked[nowR][nowC] -= 1;
                nowR = nowR+ dr[i];
                nowC = nowC+ dc[i];
            }
        }
    }
    static boolean isPossible(int r, int c){
        if( r >= 1 && r <= n && c >=1 && c<=n ){
            return true;
        }
        return false;
    }
}
