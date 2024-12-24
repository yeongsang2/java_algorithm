
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    static int answer= 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        if(n==1){
            System.out.println(0);
            return;
        }
        List<List<Node>> list = new ArrayList<>();
        int[] cost = new int[n+1];
        boolean[] checked = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            list.get(parent).add(new Node(child,dist));
            list.get(child).add(new Node(parent,dist));
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        while(!queue.isEmpty()){
            Integer parent = queue.poll();
            if(checked[parent]) continue;
            checked[parent] = true;
            for(Node child : list.get(parent)){
                if(!checked[child.idx]) {
                    cost[child.idx] = cost[parent] + child.cost;
                    queue.add(child.idx);
                }
            }
        }


        int value = 0;
        Queue<Node> tempPq = new PriorityQueue<Node>( (o1,o2) ->  o2.cost - o1.cost );
        for (int i = 1; i < n+1; i++) {
            tempPq.add(new Node(i, cost[i]));
        }
        int start = tempPq.poll().idx;
        int end = tempPq.poll().idx;

        Queue<Node> pq = new PriorityQueue<Node>( (o1,o2) ->  o2.cost - o1.cost );
        pq.add(new Node(start, 0));
        cost = new int[n+1];
        checked = new boolean[n+1];

        while(!pq.isEmpty()){
            Node parent = pq.poll();
            if(checked[parent.idx]) continue;
            checked[parent.idx] = true;
            List<Node> childList = list.get(parent.idx);
            for(Node child : childList){
                if(!checked[child.idx]){
                    cost[child.idx] = cost[parent.idx] + child.cost;
                    pq.add(new Node(child.idx, cost[child.idx]));
                }
            }
        }
        int answer = 0;
        for(int i =1; i < n+1; i++ ){
            answer = Math.max(answer, cost[i]);
        }
        System.out.println(answer);
    }
//    static void search(List<List<Node>> list, int now, int sum){
//
//
//    }
}
