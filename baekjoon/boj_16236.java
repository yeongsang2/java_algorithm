package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_16236 {

    static class Shark{
        int r;
        int c;
        int size;
        int count;
        public Shark(){
            this.size =2;
            this.count = 0;
        }
    }
    static class Loc{
        int r;
        int c;
        int distance;
        public Loc(int r, int c, int distance){
            this.r= r;
            this.c =c;
            this.distance = distance;
        }
    }

    static int[][] board;
    //좌 상 하 우
    static int[] dr = {0,-1,1,0};
    static int[] dc = {-1,0,0,1};
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        Shark shark = new Shark();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 9){
                    shark.r = i;
                    shark.c = j;
                }
            }
        }

        int answer = 0;
        while(true){
            board[shark.r][shark.c] = 0;
            Queue<Loc> queue = new PriorityQueue<>(
                (o1, o2) -> {
                    //이동거리다름
                    if(o1.distance != o2.distance) return Integer.compare(o1.distance, o2.distance);
                    //y 같음
                    if(o1.r == o2.r) return Integer.compare(o1.c, o2.c);
                    return Integer.compare(o1.r, o2.r);
                }
            );
            queue.add(new Loc(shark.r, shark.c,0));
            int count = 0;
            boolean[][] visited= new boolean[n][n];
            visited[shark.r][shark.c] = true;
            boolean flag = false;
            while(!queue.isEmpty()){
                flag = false;
                Loc poll = queue.poll();
                if(board[poll.r][poll.c] < shark.size && board[poll.r][poll.c] != 0){ //도착
                    answer += poll.distance;
                    board[poll.r][poll.c] = 9; //shark 위치
                    shark.r = poll.r;
                    shark.c = poll.c;
                    shark.count++;
                    if(shark.count == shark.size){
                        shark.size++;
                        shark.count= 0;
                    }
                    flag = true;
                    break;
                }
                for (int i = 0; i < 4; i++) { //상하좌우
                    int nextR = poll.r + dr[i];
                    int nextC = poll.c + dc[i];
                    if(isRanged(nextR, nextC) && !visited[nextR][nextC]){
                            //이동가능
                        if(board[nextR][nextC] <= shark.size){
                            queue.add(new Loc(nextR, nextC, poll.distance+1));
                            visited[nextR][nextC] = true;
                        }
                    }
                }
                count++;
                if (flag){
                    break;
                }
            }
            if(!flag){
                break;
            }
        }
        System.out.println(answer);
    }
    static boolean isRanged(int r, int c ){
        if( r>= 0 && r < n  && c>=0 && c <n){
            return true;
        }
        return false;
    }
}
