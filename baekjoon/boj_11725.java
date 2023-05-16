package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for( int i =0; i <n ; i++){
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken()) -1 ;
            int n2 = Integer.parseInt(st.nextToken()) -1 ;
            tree.get(n1).add(n2);
            tree.get(n2).add(n1);
        }

        boolean[] visited = new boolean[n]; // 방문 여부 확인
        int[] parentNode = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        while(!stack.isEmpty()){
            int s = stack.pop();
            visited[s] = true;
            for (Integer i: tree.get(s)) {
                if(!visited[i]) {
                    stack.add(i);
                    parentNode[i] = s;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            System.out.println(parentNode[i] + 1);
        }

    }
}
