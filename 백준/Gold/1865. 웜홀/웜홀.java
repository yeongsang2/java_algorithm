import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    static class Node{
        int idx;
        int cost;
        public Node(int idx, int cost){
            this.idx = idx;
            this.cost = cost;
        }
    }
    static int n, m, w;
    static List<List<Node>> list;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb= new StringBuilder();
        while(tc-- > 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 지점
            m = Integer.parseInt(st.nextToken()); // 도로 -> 방향 없음
            w = Integer.parseInt(st.nextToken()); // 웜홀 -> 방향 있음

            list = new LinkedList<>();

//            for (int i = 0; i < n + 1; i++) {
//                list.add(new LinkedList<>());
//            }
            arr = new int[n+1][n+1];
            init();
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
//                list.get(a).add(new Node(b,c));
//                list.get(b).add(new Node(a,c));
                arr[a][b] = Math.min(arr[a][b], c);
                arr[b][a] = Math.min(arr[b][a], c);
            }

            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int temp = -c;
                arr[a][b] = temp;
//                list.get(a).add(new Node(b, temp));
            }
            for (int i = 1; i < n+1; i++) {
                search(i);
            }

            boolean flag =  false;
            for (int i = 1; i < n+1; i++) {
                for (int j = 1; j < n+1; j++) {
                    if( i== j && arr[i][j] < 0){
                        flag = true;
                        break;
                    }
                }
            }

            if(flag){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static void init(){
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if(i == j){
                    arr[i][j] = 0;
                }else{
                    arr[i][j] = 1000000000;
                }
            }
        }
    }

    static void search(int start){

        Queue<Node> queue = new LinkedList<>();
//        boolean[] checked = new boolean[n+1];
        queue.add(new Node(start,0));

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                arr[start][j] = Math.min(arr[start][j], arr[start][i] + arr[i][j]);
            }
        }

    }
}
