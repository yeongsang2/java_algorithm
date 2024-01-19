package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_13023 {

    static List<Integer>[] list;
    static boolean status;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list= new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            visited = new boolean[n];
            dfs(i,0);
            if(status){
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }
    static void dfs(int idx, int depth){
        if(depth == 4){
            status = true;
            return;
            //
        }

        visited[idx] = true;
        for (Integer integer : list[idx]) {
            if(!visited[integer]){
                dfs(integer, depth+1);
            }
        }
        visited[idx] = false;
    }
}
