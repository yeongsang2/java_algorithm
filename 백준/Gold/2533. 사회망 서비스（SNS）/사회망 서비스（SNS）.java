
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<List<Integer>> childList = new ArrayList<>();

    static int[][] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        childList = new ArrayList<>();

        for (int i = 0; i < n + 1; i++) {
            childList.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            childList.get(parent).add(child);
            childList.get(child).add(parent);
        }

        dp = new int[n + 1][2]; // 0 내가 얼리어답터, 1 내가 얼리어답터가 아님
        search(1);
        visited[1] = true;
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static public void search(int node){

        visited[node] = true;
        for(Integer child : childList.get(node)){
            if(!visited[child]){
                visited[child] = true;
                search(child);
                dp[node][0] += Math.min(dp[child][1], dp[child][0]);
                dp[node][1] += dp[child][0];
            }
        }
        dp[node][0] +=1;
//        System.out.println(node + ": " + dp[node][0] + " " + dp[node][1]);

    }
}
