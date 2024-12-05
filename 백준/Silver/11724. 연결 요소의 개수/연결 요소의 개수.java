
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        LinkedList<LinkedList<Integer>> graph = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];


        for (int i = 0; i < n+1; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        for (int i = 1; i < n+1; i++) {
            if(!visited[i]){
                cnt++;
                visited[i] = true;
                queue.add(i);
                while(!queue.isEmpty()){
                    Integer poll = queue.poll();
                    for(Integer integer : graph.get(poll)){
                        if(!visited[integer]){
                            visited[integer] = true;
                            queue.add(integer);
                        }
                    }
                }
            }
        }
        System.out.println(cnt);


    }
}
