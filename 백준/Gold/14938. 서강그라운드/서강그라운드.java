import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int r;
    static int[] itemArr;

    static class Node implements Comparable<Node> {
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
    static List<List<Node>> list = new LinkedList<>();
    static int cost = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        itemArr = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n+1; i++) {
            itemArr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n+1; i++) {
            list.add(new LinkedList<>());
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(a).add(new Node(b,c));
            list.get(b).add(new Node(a,c));
        }
        for (int i = 1; i < n+1; i++) {
//            System.out.println("Area: " +  i);
            search(i);
//            System.out.println();
        }

        System.out.println(cost);
    }
    static void search(int start){
        Queue<Node> pq = new PriorityQueue<>();
        boolean[] checked = new boolean[n+1];
        int[] answer = new int[n+1];
        Arrays.fill(answer, 100000);
        answer[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()){
            Node now = pq.poll();
            if(checked[now.idx]) continue;
            checked[now.idx] = true;
            for(Node node : list.get(now.idx)){
                if(!checked[node.idx] && ( answer[node.idx] > answer[now.idx] + node.cost ) ){
                    answer[node.idx] = answer[now.idx] + node.cost;
                    pq.add(new Node(node.idx, answer[node.idx]));
                }
            }
        }

        int temp = 0;
        for (int i = 1; i < answer.length; i++) {
//            System.out.print(answer[i] + " ");
            if(answer[i] <= m){
                temp += itemArr[i];
            }
        }
//        System.out.println();
        cost = Math.max(cost, temp);
//        System.out.println("cost:" + cost);
    }
}
