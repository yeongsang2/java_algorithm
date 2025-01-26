
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node>{
        int start;
        int end;
        int cost;
        public Node(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int n;
    static int m;
    static int[] parent;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            pq.add(new Node(a,b,c));
        }

        for (int i = 0; i < n+1; i++) {
            parent[i] = i;
        }

        int answer = 0;
        int maxEdgeCost = 0; // MST에서 가장 비용이 큰 간선을 저장


        while (!pq.isEmpty()){
            Node now = pq.poll();

            int start = now.start;
            int end = now.end;
            if(findRoot(start) == findRoot(end)) continue;
            answer += now.cost;
//            System.out.println(start + " " + end + " " + now.cost);
            union(start, end);
            maxEdgeCost = now.cost; // 가장 마지막으로 추가된 간선이 항상 가장 큰 비용

        }

        System.out.println(answer-maxEdgeCost);
    }
    static int findRoot(int node) {
        if (parent[node] != node) {
            parent[node] = findRoot(parent[node]); // 경로 압축
        }
        return parent[node];
    }
    static void union(int x, int y){
        int x1 = findRoot(x);
        int y2 = findRoot(y);

        if(x1 != y2) parent[x1] = y2;
    }
}
