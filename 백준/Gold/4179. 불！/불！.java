import java.io.*;
import java.util.*;

public class Main {
    static int r, c;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node {
        int row, col, time;
        boolean isFire;

        Node(int row, int col, int time, boolean isFire) {
            this.row = row;
            this.col = col;
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
        Queue<Node> queue = new LinkedList<>();

        int jR = 0, jC = 0;

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    jR = i;
                    jC = j;
                } else if (map[i][j] == 'F') {
                    queue.add(new Node(i, j, 0, true)); // 불 먼저 큐에 삽입
                }
            }
        }

        // 지훈도 큐에 삽입 (불보다 나중에 실행되도록)
        queue.add(new Node(jR, jC, 0, false));

        int result = bfs(queue);
        System.out.println(result == -1 ? "IMPOSSIBLE" : result);
    }

    static int bfs(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            // 지훈이 탈출했을 경우
            if (!cur.isFire && (cur.row == 0 || cur.row == r - 1 || cur.col == 0 || cur.col == c - 1)) {
                return cur.time + 1;
            }

            for (int i = 0; i < 4; i++) {
                int nextR = cur.row + dr[i];
                int nextC = cur.col + dc[i];

                if (nextR < 0 || nextR >= r || nextC < 0 || nextC >= c) continue;
                if (map[nextR][nextC] == '#' || map[nextR][nextC] == 'F') continue;

                // 불 확산
                if (cur.isFire) {
                    map[nextR][nextC] = 'F';
                    queue.add(new Node(nextR, nextC, cur.time + 1, true));
                }
                // 지훈 이동
                else {
                    if (map[nextR][nextC] == '.') { 
                        map[nextR][nextC] = 'J'; // 방문 처리
                        queue.add(new Node(nextR, nextC, cur.time + 1, false));
                    }
                }
            }
        }
        return -1; // 탈출 불가능
    }
}
