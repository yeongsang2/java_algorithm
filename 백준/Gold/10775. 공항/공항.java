
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        parent = new int[g+1];
        for (int i = 0; i < g + 1; i++) {
            parent[i] = i;
        }

        int cnt = 0;
        while(p-- > 0){

            int num = Integer.parseInt(br.readLine());
            int root = findRoot(num);

            if(root == 0)break;

            union(root, root - 1);
            cnt++;
        }
        System.out.println(cnt);
    }
    static int findRoot(int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = findRoot(parent[x]);
        return parent[x];
    }

    static void union(int x, int y){
        int parentY = findRoot(y);
        parent[x] = parentY;
    }
}
