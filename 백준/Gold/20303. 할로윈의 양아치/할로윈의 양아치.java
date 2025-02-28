
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    static int[] arr;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());;
        int[] candyCntArr = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            int num = Integer.parseInt(st.nextToken());
            candyCntArr[i] = num;
        }

        List<List<Integer>> relations = new ArrayList<>();

        for (int i = 0; i <  n + 1; i++) {
            relations.add(new ArrayList<>());
        }

        arr = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int rootA = findRoot(a);
            int rootB = findRoot(b);
            if( rootA == rootB ) continue;

            union(rootA, rootB);
        }

        HashMap<Integer, Integer> candyCountMap = new HashMap<>();
        HashMap<Integer, Integer> relationCountMap = new HashMap<>();
        // 영역 + 동시에 뺏기는 갯수 게산
        for (int i = 1; i < n + 1; i++) {
            int root = findRoot(i); // 루트 노드 찾기
            candyCountMap.put(root, candyCountMap.getOrDefault(root, 0) + candyCntArr[i]);
            relationCountMap.put(root, relationCountMap.getOrDefault(root, 0) + 1);
        }

        long[] dp = new long[k]; // i명의 아이들이 울 때의 최대 사탕 개수

        for (int root : candyCountMap.keySet()) {
            int groupSize = relationCountMap.get(root); // 그룹에 속한 아이들의 수
            int groupCandy = candyCountMap.get(root);  // 그룹에서 빼앗을 수 있는 사탕 수

            for (int i = k - 1; i >= groupSize; i--) {
                dp[i] = Math.max(dp[i], dp[i - groupSize] + groupCandy);
            }
        }
        System.out.println(dp[k - 1]);
    }
    static public int findRoot(int node){
        if(arr[node] == node){
            return node;
        }
        arr[node] = findRoot(arr[node]);
        return arr[node];
    }

    static public void union(int a, int b){
        if(a < b){
            arr[b] = a;
        }else{
            arr[a] = b;
        }
    }
}
