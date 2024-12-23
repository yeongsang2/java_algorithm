
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx; // 현재 idx
            this.cost = cost; // 노드까지 오는 비용
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    static int[] dist;
    static boolean[] check;
    static final int INF = 200000000;
    static List<List<Node>> list = new LinkedList<>();


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =  new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        dist = new int[n+1];
        check = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            list.add(new LinkedList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b, cost));
            list.get(b).add(new Node(a, cost));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, n);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, n);

        int answer = Math.min(res1, res2);
        if(answer >= INF){
            System.out.println(-1);
        }else{
            System.out.println(answer);
        }
//        System.out.println(Math.min(res1, res2));
    }
    static int dijkstra(int start, int end){

        Arrays.fill(dist, INF);
        Arrays.fill(check, false);

        Queue<Node> queue = new PriorityQueue<>();
        dist[start] = 0;
        queue.add(new Node(start,0));

        while(!queue.isEmpty()){
            Node now = queue.poll();
            if(!check[now.idx]){
                check[now.idx] = true;
                for(Node node: list.get(now.idx)){
                    if(!check[node.idx]){
                        if(dist[node.idx] > dist[now.idx] + node.cost){
                            dist[node.idx] = dist[now.idx] + node.cost;
                            queue.add(new Node(node.idx, dist[node.idx]));
                        }
                    }
                }
            }
        }

        return dist[end];
    }
}
