package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek3 {

    public static int n,k;
    public static int min = Integer.MAX_VALUE;
    public static boolean[] visited = new boolean[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(min);
    }

    public static class Human{
        int loc;
        int time;

        public Human(int loc, int time) {
            this.loc = loc;
            this.time = time;
        }
    }

    public static void bfs(){

        Queue<Human> queue = new LinkedList<>();

        queue.add(new Human(n, 0));
        int next;

        while(!queue.isEmpty()){

            Human poll = queue.poll();
            int now = poll.loc;
            int time = poll.time;

            if(now==k){ //잡았을경우
                min = Math.min(min, time);
            }

            next = now *2; // 0초후 2*X 위치로 이동
            if(next < 100001 && !visited[next]){
                visited[next] = true;
                queue.add(new Human(next, time));
            }

            next = now -1; // 0초후 x-1 위치로 이동
            if( next >= 0 && !visited[next]){
                visited[next] = true;
                queue.add(new Human(next, time+1));
            }

            next = now +1; // 0초후 x+1 위치로 이동
            if( next < 100001 && !visited[next]){
                visited[next] = true;
                queue.add(new Human(next, time+1));
            }

            }
        }
 }
