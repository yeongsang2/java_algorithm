package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class boj_21608 {

    static int n;
    static HashMap<Integer, int[]> map;
    static int[][] board;
    static int[][] countBoard;
    static int[] order;

    // 상하좌우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        order = new int[n*n+1];
        board = new int[n+1][n+1];
        countBoard = new int[n+1][n+1];


        for (int i = 1; i < n * n + 1; i++) {
            String[] str = br.readLine().split(" ");
            int[] likeNum = new int[]{ Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3]), Integer.parseInt(str[4])};
            map.put(Integer.parseInt(str[0]), likeNum);
            order[i] = Integer.parseInt(str[0]);
        }

        board[2][2] = order[1];
        for (int i = 2; i < n * n + 1; i++) {
            initCountBoard();
            checkOne(order[i]);
        }
        int score = calculateScore();
        System.out.println(score);

    }

    private static void testDraw() {
        for (int i = 1; i < n +1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    static void checkOne(int num){
        int[] adj = map.get(num);
        for (int i = 1; i < n +1 ; i++) {
            for (int j = 1; j < n+1 ; j++) {
                if(board[i][j] == adj[0] || board[i][j] == adj[1] || board[i][j] == adj[2] || board[i][j] == adj[3]){
                    for (int k = 0; k < 4; k++) {
                        int nowR = i + dr[k];
                        int nowC = j + dc[k];
                        if(checkRange(nowR, nowC) ){
                            if(board[nowR][nowC] == 0) {
                                countBoard[nowR][nowC] += 1;
                            }
                        }
                    }
                }
            }
        }

        int[] checkNum = checkLocate();
        board[checkNum[0]][checkNum[1]] = num;
    }
    static int[] checkLocate(){
        //일단 맥스값 찾기
        int max = -1;
        int r = -1;
        int c = -1;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 1; i < n +1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                max = Math.max(max, countBoard[i][j]);
            }
        }

        for (int i = 1; i < n +1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                if(countBoard[i][j] == max){
                    if(board[i][j] == 0) {
                        list.add(new int[]{i, j});
                    }
                }
            }
        }

        int maxPossible = -1;
        for(int[] i : list) {

            int count = 0;
            for (int k = 0; k < 4; k++) {
                int nowR = i[0] + dr[k];
                int nowC = i[1] + dc[k];
                if(checkRange(nowR, nowC) ){
                    if(board[nowR][nowC] == 0) {
                        count++;
                    }
                }
            }

            if (maxPossible < count){
                maxPossible = count;
                r = i[0];
                c = i[1];
            }
            if (maxPossible == count){
                continue;
            }
        }

        return new int[]{r,c};
    }
    static void initCountBoard(){
        for (int i = 1; i < n +1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                countBoard[i][j] = 0;
            }
        }
    }

    static boolean checkRange(int r, int c){
        if(r > 0 && r < n + 1 && c > 0 && c < n +1) return true;
        return false;
    }
    static int calculateScore(){
        int score = 0;
        for (int i = 1; i < n +1 ; i++) {
            for (int j = 1; j < n+1; j++) {
                int count =0;
                int nowNum = board[i][j];
                int[] favNum = map.get(nowNum);
                for (int k = 0; k < 4; k++) {
                    int nowR = i + dr[k];
                    int nowC = j + dc[k];
                    if(checkRange(nowR, nowC)){
                        if(board[nowR][nowC] == favNum[0] || board[nowR][nowC] == favNum[1] || board[nowR][nowC] == favNum[2] || board[nowR][nowC] == favNum[3]){
                            count = count+1;
                        }
                    }
                }
                if(count ==0){
                    score +=0;
                }
                if(count ==1){
                    score +=1;
                }
                if(count ==2){
                    score +=10;
                }
                if(count ==3){
                    score +=100;
                }
                if(count ==4){
                    score +=1000;
                }
            }
        }
        return score;
    }
}
