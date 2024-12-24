
import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int idx;
        int dist;
        public Node(int idx, int dist){
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o){
            return this.dist - o.dist;
        }
    }

    static final int INF = 100000000;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int start = Integer.parseInt(br.readLine());

        List<Node>[] list = new ArrayList[v+1];

        for (int i = 0; i < v+1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
//            list.get(a).add(new Node(b,c));
            list[a].add(new Node(b,c));
        }

        Queue<Node> pq = new PriorityQueue<>();

        int[] cost = new int[v+1];
        boolean[] checked= new boolean[v+1];
        Arrays.fill(cost, INF);
        Arrays.fill(checked, false);
        pq.add(new Node(start, 0));
        cost[start] = 0;

        while(!pq.isEmpty()){
            Node poll = pq.poll();
            int cur = poll.idx;
            if(checked[cur]) continue;
            checked[cur] = true;
            for(Node node : list[cur]){
                if(!checked[node.idx] && (cost[node.idx] > cost[cur] + node.dist)){
                    cost[node.idx] = cost[cur] + node.dist;
                    pq.add(new Node(node.idx, cost[node.idx]));
                }
            }
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < v+1 ; i++) {
            if(cost[i] >= INF){
                sb.append("INF");
                sb.append("\n");
            }else{
                sb.append(cost[i]);
                sb.append("\n");
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.close();
    }
}
