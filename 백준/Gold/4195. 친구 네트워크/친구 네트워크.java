import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static Map<String, Integer> map;
    static int[] parent;
    static int[] level;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int n = Integer.parseInt(br.readLine());
            map = new HashMap<>();

            parent = new int[n * 2];
            level = new int[n * 2];

            for (int i = 0; i < n * 2; i++) {
                parent[i] = i;
                level[i] = 1;
            }

            int idx = 0;
            for (int i = 0; i < n; i++) {

                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                if(!map.containsKey(a)){
                    map.put(a, idx++);
                }
                if(!map.containsKey(b)){
                    map.put(b, idx++);
                }
                int temp = union(map.get(a), map.get(b));
                sb.append(temp).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static int findRoot(int x){
        if(x == parent[x]){
            return x;
        }
        return parent[x] = findRoot(parent[x]);
    }

    static int union(int a, int b){

        int rootA = findRoot(a);
        int rootB = findRoot(b);

        if(rootA != rootB){
            // a < b;
            parent[rootB] = rootA;
            level[rootA] += level[rootB];
//            level[rootB] = 1;
        }
        return level[rootA];

    }
}
