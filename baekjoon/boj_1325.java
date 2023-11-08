package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_1325 {

    static List<Integer>[] table;
    static int cnt;
    static int max = -1;
    static boolean[] visited;
    static int[] counted;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        table = new LinkedList[n+1];
        counted = new int[n+1];

        for (int i = 1; i < n+1; i++) {
            table[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // a가 b를 신뢰한다 b를 해킹하면 a도 해킹가능
            table[a].add(b);
        }

        for (int i = 1; i <n+1 ; i++) {
            visited = new boolean[n+1];
            visited[i] = true;
            counted[i]++;
            dfs(i);
        }

        int max = -1;
        for (int i = 1; i < n+1; i++) {
            max = Math.max(max,counted[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            if(counted[i] == max) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);

    }

    static void dfs(int n){
        for(int next : table[n]){
            if(!visited[next]){
                visited[next] = true;
                counted[next]++;
                dfs(next);
            }
        }
    }
}
