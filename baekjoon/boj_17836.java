package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_17836 {


    static class Person{

        int r;
        int c;
        public Person(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    static int[][] board;
    static int[][] answer;
    static int n;
    static int m;
    //상 하 좌 우
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[n+1][m+1];
        int T = Integer.parseInt(st.nextToken());

        board = new int[n+1][m+1];
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer[1][1] = 0;
        int tempAnswer = Integer.MAX_VALUE;
        Queue<Person> queue = new LinkedList<>();
        queue.add(new Person(1,1));

        while(!queue.isEmpty()){
            Person poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextR = poll.r + dr[i];
                int nextC = poll.c + dc[i];
                if(isRanged(nextR,nextC)){
                    if(board[nextR][nextC] != 1 && answer[nextR][nextC] == 0){
                            answer[nextR][nextC] = answer[poll.r][poll.c] +1;
                            Person p = new Person(nextR, nextC);
                            if(board[nextR][nextC] == 2){
                                tempAnswer = answer[nextR][nextC] + (n- nextR) + (m - nextC);
                            }
                            queue.add(p);
                    }
                }
            }
        }

        if(answer[n][m] == 0){ //도착 못
            if(tempAnswer > T ){
                System.out.println("Fail");
            }else{
                System.out.println(tempAnswer);
            }
        }else {
            int t = Math.min(answer[n][m], tempAnswer);
            if(t > T ){
                System.out.println("Fail");
            }else{
                System.out.println(t);
            }
        }

    }

    private static boolean isRanged(int nextR, int nextC) {
        if (nextR < n + 1 && nextR > 0 && nextC < m + 1 && nextC > 0) {
            return true;
        }
        return false;
    }
}
