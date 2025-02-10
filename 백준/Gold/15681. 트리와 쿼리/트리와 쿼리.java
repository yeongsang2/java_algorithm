
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, r, q;
    static List<List<Integer>> list;
    static boolean[] visited;
    static long[] count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n -1 ; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        visited = new boolean[n+1];
        visited[r] = true;
        count = new long[n+1];
        count[r] = search(r);
        StringBuilder sb = new StringBuilder();
        while(q-- >0){
            int num = Integer.parseInt(br.readLine());
            sb.append(count[num]);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
    static public long search(int node){

        if(list.get(node).size() == 1 && node != r){ // 마지막
            count[node] = 1;
            return count[node];
        }

        long cnt = 0;
        for(int next : list.get(node)){
            if(!visited[next]){
                visited[next] = true;
                cnt += search(next);
            }
        }
        count[node] = cnt + 1;
        return count[node];
    }
}
