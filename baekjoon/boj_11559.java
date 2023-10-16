package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj_11559 {


    public static class Loc{

        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
        int r;
        int c;
    }
    static String[][] map = new String[12][6];
    static boolean[][] visited = new boolean[12][6];

    public static void init(){
        for(int i =0; i< 12; i++){
            for(int j =0 ; j < 6; j ++){
                visited[i][j] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in) );
        // 상 좌 우 하
        int[] dr = {-1 ,0,0, 1};
        int[] dc = {0, -1,1,0};

        int answer = 0;
        String[][] map = new String[12][6];
        for(int i =0; i< 12; i++){
            String s = br.readLine();
            for(int j =0 ; j < s.length(); j ++){
                map[i][j] = String.valueOf(s.charAt(j));
            }
        }
        boolean check = true;
        while(check) {
            check = false;
            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    String now = map[i][j];
                    Queue<Loc> queue = new LinkedList<>();
                    Queue<Loc> queueList = new LinkedList<>();
                    if (!now.equals(".") ) {
                        queue.add(new Loc(i, j));
                        queueList.add(new Loc(i, j));
                        visited[i][j] = true;
                        int cnt = 1;
                        while (!queue.isEmpty()) {
                            Loc loc = queue.poll();
                            for (int k = 0; k < 4; k++) {
                                int nowR = loc.r - dr[k];
                                int nowC = loc.c - dc[k];
                                if (nowR >= 0 && nowR < 12 && nowC >= 0 && nowC < 6 && map[nowR][nowC].equals(now)) {
                                    if(!visited[nowR][nowC]) {
                                        visited[nowR][nowC] = true;
                                        queue.add(new Loc(nowR, nowC));
                                        queueList.add(new Loc(nowR, nowC));
                                        cnt++;
                                    }
                                }
                            }
                        }
                        if (queueList.size() >= 4) {
                            while (!queueList.isEmpty()) {
                                Loc nowLoc = queueList.poll();
                                move(nowLoc.c);
                            }
                            answer++;
                            check = true;
                            init();
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
    public static void move(int c){
        map[0][c] = ".";
        for(int r= 1 ; r < 12; r++){
            map[r][c] = map[r-1][c];
        }   
    }
}
