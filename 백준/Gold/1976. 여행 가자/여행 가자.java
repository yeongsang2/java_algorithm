
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] map = new int[n + 1][n + 1];
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            st =  new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                int num = Integer.parseInt(st.nextToken());
                if(num == 1){ //
                    int rootA = findRoot(i);
                    int rootB = findRoot(j);
                    if(rootA == rootB) continue;
                    union(rootA, rootB);
                }
            }
        }

//        for (int i = 1; i < n + 1; i++) {
//            System.out.print(parent[i] + " ");
//        }

        st = new StringTokenizer(br.readLine());
        int[] trip = new int[m];
        for (int i = 0; i < m; i++) {
            trip[i] = Integer.parseInt(st.nextToken());
        }

        boolean flag = true;
        for (int i = 0; i < m - 1; i++) {
            int now = trip[i];
            int next = trip[i+1];
            if(findRoot(now) != findRoot(next)){
                flag = false;
                break;
            }
        }
        if(flag) System.out.println("YES");
        else System.out.println("NO");

    }
    static int findRoot(int node){
        if(parent[node] == node){
            return node;
        }
        parent[node] = findRoot(parent[node]);
        return parent[node];
    }

    static void union(int a, int b){
        if(a <= b){
            parent[b] = a;
        }else {
            parent[a] = b;
        }
    }
}
