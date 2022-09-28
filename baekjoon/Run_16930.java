package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Run_16930 {

    public static int N,M,K;
    public static int x1,y1,x2,y2;
    public static int[][] wall = new int[1001][1001];
    public static int[][] visited = new int[1001][10001];

    public static int[] dr = {-1,1,0,0};
    public static int[] dc = {0,0,-1,1};

    public static int answer = Integer.MAX_VALUE;

    static class Point{
        public int x;
        public int y;
        public int distance; //이동거리?

        public Point(int x, int y, int distance){
            this.x = x;
            this.y=  y;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0 ; i< N ; i++){
            String str = br.readLine();
            for(int j=0; j<M ; j++){
                char c = Character.valueOf(str.charAt(j));
                if(c == '#'){
                    wall[i][j] = 1;
                }else{
                    wall[i][j] = 0;
                }
            }
        }

        st = new StringTokenizer(br.readLine());

        x1 = Integer.parseInt(st.nextToken()) -1;
        y1 = Integer.parseInt(st.nextToken()) -1;
        x2 = Integer.parseInt(st.nextToken()) -1;
        y2 = Integer.parseInt(st.nextToken()) -1;

        initVisited();
        bfs();

        if(answer == Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(answer);
        }

    }

    public static void bfs(){

        Queue<Point> queue = new LinkedList();
        queue.add(new Point(x1,y1, 0));
        visited[x1][y1] = 0;
        while (!queue.isEmpty()){

            Point poll = queue.poll();
            if(poll.x == x2 && poll.y == y2){
                answer = Math.min(answer, poll.distance);
                break;
            }

            //상 하 좌 우 체크
            for(int i=0; i< 4 ;i++) {
                for (int j = 1; j < K + 1; j++) { // K(최대 이동 가능)까지 이동

                    int newX = poll.x + dr[i]*j;
                    int newY = poll.y + dc[i]*j; //방향
                    if(newX < 0 || newX >=N || newY < 0 || newY >=M || wall[newX][newY] ==1)break;
                    if(visited[newX][newY] == Integer.MAX_VALUE){ //아직 방문 x
                        queue.add(new Point(newX, newY, poll.distance + 1 ));
                        visited[newX][newY] = poll.distance+1;
                    }else if(visited[newX][newY] == poll.distance+1) {
                        continue;
                    }else{
                        break;
                    }
                }
            }
        }
    }


    public static void initVisited(){
        for(int i=0 ; i< N ; i++){
            for(int j=0; j<M ; j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
    }

}
