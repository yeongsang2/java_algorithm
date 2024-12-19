
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node>{
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o){
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] cost = new int[n+1];
        boolean[] visited = new boolean[n+1];

        Arrays.fill(cost, Integer.MAX_VALUE);
        List<List<Node>> list = new LinkedList<>();

        for (int i = 0; i < n+1; i++) {
            list.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        Queue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start,0));
        cost[start] = 0;
//        visited[start] = true;
        while(!queue.isEmpty()){

            Node now = queue.poll();

            if(!visited[now.idx]){
                visited[now.idx] = true;
                for(Node node : list.get(now.idx)){
                    if(!visited[node.idx] && ( cost[node.idx] > cost[now.idx] + node.cost ) ){
                        cost[node.idx] = cost[now.idx] + node.cost;
//                        queue.add(node);
                        queue.add(new Node(node.idx, cost[node.idx]));
                    }
                }
            }
        }

        System.out.println(cost[end]);
    }
}
