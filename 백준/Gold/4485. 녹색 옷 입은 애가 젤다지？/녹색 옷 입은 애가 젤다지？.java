import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] checked;
    static int[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int answer = Integer.MAX_VALUE;

    static class Node implements Comparable<Node> {
        int r;
        int c;
        int value;
        public Node(int r, int c, int value){
            this.r = r;
            this.c = c;
            this.value = value;
        }

        public int compareTo(Node o){
            return this.value - o.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        while (true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                break;
            }

            StringTokenizer st;
            checked = new boolean[n][n];
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            checked[0][0] = true;
            int[][] value = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    value[i][j] = 10000001;
                }
            }

            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(0,0, map[0][0]));
            value[0][0] = map[0][0];
            while (!pq.isEmpty()){
                Node poll = pq.poll();
                for (int i = 0; i < 4; i++) {
                    int nextR = poll.r + dr[i];
                    int nextC = poll.c + dc[i];
                    if(nextR < n && nextR >= 0 && nextC < n && nextC >= 0
                            && value[nextR][nextC] > value[poll.r][poll.c] + map[nextR][nextC]){
                        value[nextR][nextC] = value[poll.r][poll.c] + map[nextR][nextC];
                        pq.add(new Node(nextR, nextC, value[nextR][nextC]));
                    }
                }
            }

            sb.append("Problem ").append(cnt).append(": ").append(value[n-1][n-1]).append("\n");
            cnt++;
        }

        System.out.println(sb.toString());
    }
    static void search(int r, int c, int n, int sum){
        if(r == n - 1 && c == n -1){
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];
            if(nextR < n && nextR >= 0 && nextC < n && nextC >=0
                && !checked[nextR][nextC]){
                checked[nextR][nextC] = true;
                search(nextR, nextC, n, sum + map[nextR][nextC]);
                checked[nextR][nextC] = false;
            }
        }
    }
}
