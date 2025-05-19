
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import java.io.*;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point> {
        int r, c, dir, mirrors;

        Point(int r, int c, int dir, int mirrors) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.mirrors = mirrors;
        }

        public int compareTo(Point o) {
            return this.mirrors - o.mirrors;
        }
    }

    static int W, H;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new char[H][W];

        List<int[]> Cs = new ArrayList<>();
        for (int i = 0; i < H; i++) {
            String line = br.readLine();
            for (int j = 0; j < W; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'C') {
                    Cs.add(new int[]{i, j});
                }
            }
        }

        int[][][] dist = new int[4][H][W];
        for (int[][] d1 : dist) {
            for (int[] d2 : d1) {
                Arrays.fill(d2, Integer.MAX_VALUE);
            }
        }

        int sr = Cs.get(0)[0];
        int sc = Cs.get(0)[1];
        int er = Cs.get(1)[0];
        int ec = Cs.get(1)[1];

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for (int d = 0; d < 4; d++) {
            dist[d][sr][sc] = 0;
            pq.offer(new Point(sr, sc, d, 0));
        }

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            if (p.r == er && p.c == ec) {
                System.out.println(p.mirrors);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = p.r + dr[d];
                int nc = p.c + dc[d];
                int nm = p.mirrors + (p.dir == d ? 0 : 1);

                if (nr < 0 || nr >= H || nc < 0 || nc >= W) continue;
                if (map[nr][nc] == '*') continue;

                if (dist[d][nr][nc] > nm) {
                    dist[d][nr][nc] = nm;
                    pq.offer(new Point(nr, nc, d, nm));
                }
            }
        }
    }
}
