import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {

    static class Node  {
        int idx;
        int cost;

        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }

    }
    static boolean[] visited;
    static int max = 0;
    static int startNode = -1;
    static int v;
    static ArrayList<Node>[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        v = Integer.parseInt(br.readLine());

        list = new ArrayList[v+1];
        for (int i = 0; i < v +1 ; i++) {
            list[i] = new ArrayList<>();
//            list.add(new LinkedList<>());
        }

        for (int i = 0; i < v; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNum = Integer.parseInt(st.nextToken());
            while (true){
                int num = Integer.parseInt(st.nextToken());
                if(num == -1){
                    break;
                }else {
                    int end = num;
                    int cost = Integer.parseInt(st.nextToken());
                    list[nodeNum].add(new Node(end, cost));
                }
            }
        }

        visited = new boolean[v+1];
        dfs(1, 0);

        max = 0;
        visited = new boolean[v+1];

        dfs(startNode, 0);
        System.out.println(max);
    }
    static void dfs(int node, int length){
        visited[node] = true;
        if(length > max){
            max = length;
            startNode = node;
        }

        for(Node now : list[node]){
            if(!visited[now.idx]){
                dfs(now.idx, length + now.cost);
                visited[now.idx] = true;
            }
        }
    }
}
