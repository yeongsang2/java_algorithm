package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2668 {

    static int n;
    static List<Integer> list = new LinkedList<>();
    static int[] board;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n+1];
        visited = new boolean[n+1];

        for (int i = 1; i < n+1; i++) {
            board[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 1; i < n+1; i++) {
            visited[i] = true;
            dfs(i,i);
            visited[i] = false;
        }
        Collections.sort(list);
        System.out.println(list.size());
        for(Integer i : list){
            System.out.println(i);
        }

    }

    static void dfs(int start, int target){
        //
        if(!visited[board[start]]){ //방문하지 않았다믄
            visited[board[start]] = true;
            dfs(board[start],target);
            visited[board[start]] = false;
        }

        if(board[start] == target){
            list.add(target);
        }
    }
}
