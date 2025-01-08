import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o){
            return this.cost-o.cost;
        }

    }

    static List<List<Node>> list =  new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1 ; i++) {
            list.add(new LinkedList<>());
        }

        String[] path = new String[n+1];
        int[] costArr = new int[n+1];

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

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        Arrays.fill(costArr, Integer.MAX_VALUE);
        costArr[start] = 0;
        path[start] = Integer.toString(start);
//        boolean[] visited = new boolean[n+1];

        while(!pq.isEmpty()){
            Node now = pq.poll();
//            visited[now.idx] = true;
            if (costArr[now.idx] < now.cost) continue;

            for(Node next : list.get(now.idx)){
                if(costArr[next.idx] > costArr[now.idx] + next.cost){
                    costArr[next.idx] =  costArr[now.idx] + next.cost;
                    path[next.idx] = path[now.idx] + " " + Integer.toString(next.idx);
                    pq.add(new Node(next.idx, costArr[next.idx]));
                }
            }
        }

        String[] s = path[end].split(" ");
        System.out.println(costArr[end]);
        System.out.println(s.length);
        System.out.println(path[end]);


    }
}
