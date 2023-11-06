package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_16234 {

    static int n;
    static int left;
    static int right;

    static int[][] board;
    static boolean[][] visited;
    static boolean flag;

    // 우측, 아래, 좌,
    static int[] dr = {0,1, 0,-1};
    static int[] dc = {1,0, -1,0};
    static class Loc{

        public Loc(int r, int c){
            this.r = r;
            this.c = c;
        }
        int r;
        int c;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = 0;
        n = Integer.parseInt(st.nextToken());
        left = Integer.parseInt(st.nextToken());
        right = Integer.parseInt(st.nextToken());
        board = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n+1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){

            List<List<Loc>> list = new LinkedList<>();
            initVisited();
            flag = false;
            // bfs 조져보면 될 거 같은데
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1 ; j++) {
                    if(!visited[i][j]){
                        visited[i][j] = true;
                        List<Loc> temp = bfs(i,j);
                        if(temp.size() > 1){ //연합형성
                            list.add(temp);
                        }
                    }
                }
            }
            if(!flag){
                System.out.println(answer);
                break;
            }
            // 인구이동
            if(list.size() >= 0){
                for(List<Loc> tempList : list){
                    int sum = 0;
                    int average= 0;
                    for(Loc loc : tempList){
                        sum += board[loc.r][loc.c];
                    }
                    average = sum / tempList.size();
                    for(Loc loc : tempList){
                        board[loc.r][loc.c] = average;
                    }
                }
            }
            answer++;
        }
    }

    static List<Loc> bfs(int r, int c){

        Queue<Loc> queue = new LinkedList<>();
        List<Loc> list = new LinkedList<>();

        queue.add(new Loc(r,c));
        list.add(new Loc(r,c));
        while(!queue.isEmpty()){
            Loc poll = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nowR = poll.r;
                int nowC = poll.c;
                int nextR = nowR + dr[i];
                int nextC = nowC + dc[i];
                if(checkRange(nextR,nextC) && !visited[nextR][nextC]){
                    int diff = Math.abs(board[nowR][nowC] - board[nextR][nextC]);
                    if(diff >= left && diff <= right){
                        flag = true;
                        visited[nextR][nextC] = true;
                        queue.add(new Loc(nextR, nextC));
                        list.add(new Loc(nextR, nextC));
                    }
                }
            }
        }
        return list;
    }
    static boolean checkRange(int r, int c){
        if( r >= 1 && r <=n && c >=1 && c <=n ){
            return true;
        }
        return false;
    }

    static void initVisited(){
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                visited[i][j] = false;
            }
        }
    }
}
