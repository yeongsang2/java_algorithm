package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10971 {

    static int[][] costBoard;
    static Map<Integer, List<Integer>> map; // 이동 가능한 도시
    static int n;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(bufferedReader.readLine());
        costBoard = new int[n][n];
        map = new HashMap<>();
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            map.put(i, new LinkedList<>());
            st = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n ; j++) {
                int value  = Integer.parseInt(st.nextToken());
                costBoard[i][j] = value;
                if(value != 0){
                    map.get(i).add(j);
                }
            }

        }

        for (int i = 0; i < n; i++) {
            search(i, i, 0, 0);
        }
        System.out.println(min);
    }
    static void search(int start, int now, int cnt, int cost){

        if(start == now && cnt != 0){
            if(cnt == n){
                min = Math.min(min, cost);
            }
            return;
        }

        for(Integer l : map.get(now)){
            if(!visited[l]){
                visited[l] = true;
                search(start,l,cnt+1,cost + costBoard[now][l]);
                visited[l] = false;
            }
        }
    }
}
