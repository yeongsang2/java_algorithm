import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n];


        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;
            tree.get(a).add(b);
            tree.get(b).add(a);
        }
        Stack<Integer> stack = new Stack<>();

        int[] parentNode = new int[n];
        visited[0] = true;

        stack.add(0);
        while(!stack.isEmpty()){
            Integer now = stack.pop();
            for(Integer i : tree.get(now)){
                if(!visited[i]){
                    visited[i] = true;
                    parentNode[i] = now;
                    stack.add(i);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            System.out.println(parentNode[i] + 1);
        }

    }

}
