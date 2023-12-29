package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_15886 {
    static int n;
    static String[] map;
    static boolean[] visited;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map =  new String[n];
        visited = new boolean[n];

        String str= br.readLine();
        for (int i = 0; i < n; i++) {
            map[i] = Character.toString(str.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            initVisited();
            //visited[i] =true;
            dfs(i);
        }

        System.out.println(set.size());
    }
    static void dfs(int pos){
        if(set.contains(pos)){
            return;
        }

        if(visited[pos]){
            set.add(pos);
            return;
        }

        visited[pos] = true;
        if(map[pos].equals("E")){
            dfs(pos+1);
        }else {
            dfs(pos-1);
        }
    }
    static void initVisited(){
        for (int i = 0; i < n; i++) {
            visited[i] = false;
        }
    }
}
