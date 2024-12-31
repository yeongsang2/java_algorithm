
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    static int m;
    static int k;

    static class Node implements Comparable<Node>{
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
    static int[][] arr;
    static List<List<Node>> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];

        for (int i = 0; i < n + 1; i++) {
            list.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list.get(a).add(new Node(b,c));
        }

        init();

        for (int i = 1; i < n + 1; i++) {
            search(i);
        }
        int answer =0 ;

//        for (int i = 1; i < n +1; i++) {
//            for (int j = 1; j < n + 1; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        for (int i = 1; i < n + 1; i++) {
            int temp = 0;
            if(i==k) continue;
            temp += arr[i][k];
            temp += arr[k][i];
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);

        // 1 ->
    }

    static void search(int start){

        arr[start][start] = 0;
        Queue<Node> queue = new PriorityQueue<Node>();
        queue.add(new Node(start,0));

        while (!queue.isEmpty()){
            Node now = queue.poll();
            for(Node node: list.get(now.idx)){
                if(arr[start][node.idx] > arr[start][now.idx] + node.cost){
                    arr[start][node.idx] = arr[start][now.idx] + node.cost;
                    queue.add(new Node(node.idx, arr[start][node.idx]));
                }
            }
        }

    }

    static void init(){
        for (int i = 1; i < n +1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if(i == j) {
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 100000;
                }
            }
        }
    }

    // 3 -> 1 : 2
    // 1 -> 2 : 4
    // 2 -> 1 : 1
    // 1 -> 3 : 2
    //          9

    // 1 -> 2 : 4
    // 2 -> 1 : 1

    // 4 -> 2 : 3
    // 2 -> 3 : 5
    // 1 -> 4 : 7

    // 4 - 2 : 3
    // 2 - 1 : 1
    // 1 - 3 : 2
    // 3 -> 4 :4
    // 10
}
