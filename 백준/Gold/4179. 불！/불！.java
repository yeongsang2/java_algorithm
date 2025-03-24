import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int r,c;
    static char[][] map;
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};
    static class Point{
        int r;
        int c;
        int time;
        boolean isFire;

        public Point(int r, int c, int time, boolean isFire){
            this.r = r;
            this.c = c;
            this.time = time;
            this.isFire = isFire;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];



        int jR = 0;
        int jC = 0;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                char temp = s.charAt(j);
                if(temp == 'J'){
                    jR = i;
                    jC = j;
                }
                if(temp == 'F'){
                    queue.add(new Point(i, j, 0, true));
                }
                map[i][j] = temp;
            }
        }

        queue.add(new Point(jR, jC, 0, false));
        int answer = bfs(queue, map);

        if(answer == -1){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(answer);
        }
    }

    static int bfs(Queue<Point> queue, char[][] map){

        while (!queue.isEmpty()){

            Point poll = queue.poll();
            if(!poll.isFire && (poll.r == 0 || poll.r == r -1 || poll.c == 0 || poll.c == c - 1) ){
                return poll.time + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = poll.r + dr[i];
                int nextC = poll.c  +dc[i];

                if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) continue;
                if (map[nextR][nextC] == '#' || map[nextR][nextC] == 'F') continue;

                if(poll.isFire){
                    map[nextR][nextC] = 'F';
                    queue.add(new Point(nextR, nextC, 0, true));
                }else{
                    if (map[nextR][nextC] == '.') {
                        map[nextR][nextC] = 'J'; // 방문 처리
                        queue.add(new Point(nextR, nextC, poll.time + 1, false));
                    }
                }
            }
        }
        return -1;
    }
}
