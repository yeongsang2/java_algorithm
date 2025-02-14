import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int arr[];

    static boolean[] checked;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            arr = new int[n + 1];
            checked = new boolean[n+1];
            visited = new boolean[n+1];
            cnt = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int start = 1; start < n + 1; start++) {
                int end = Integer.parseInt(st.nextToken());
                arr[start] = end;

            }
            for (int i = 1; i < n + 1; i++) {
                dfs(i);
            }
            System.out.println(n - cnt);

        }

    }
    static void dfs(int node){

        visited[node] = true;
        int next = arr[node];
        if(!visited[next]){
            dfs(next);
        }else{
            if(!checked[next]){
                cnt++;
                while(node != next){ // 4 7 , 4 6, 4 7
                    cnt++;
                    next = arr[next];
                }

            }
        }
        checked[node] = true;

    }
}
