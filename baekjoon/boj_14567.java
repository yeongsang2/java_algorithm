package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_14567 {

    static class Subject implements Comparable<Subject> {
        int a;
        int b;
        public Subject(int a, int b){
            this.a = a;
            this.b = b;
        }


        @Override
        public int compareTo(Subject o) {
            return this.a - o.a;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dp = new int[n+1];
        Queue<Subject> queue = new PriorityQueue<>();

        for (int i = 1; i < n+1; i++) {
            dp[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            queue.add(new Subject(a,b));
        }
        while(!queue.isEmpty()){
            Subject poll = queue.poll();
            int a = poll.a;
            int b= poll.b;
            dp[b] = Math.max(dp[b] ,dp[a] + 1);
        }
        for (int i = 1; i < n+1; i++) {
            System.out.print(dp[i] + " ");
        }
    }
}
