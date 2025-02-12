
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        int[] indegree = new int[n+1];

        while (m-- > 0){
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int count = arr[0];

            for (int i = 1; i < count ; i++) {
                int start = arr[i];
                int end = arr[i+1];
                list.get(start).add(end);
                indegree[end]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
//        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()){
//            cnt++;
            Integer now = queue.poll();
            sb.append(now).append("\n");

            for(Integer next : list.get(now)){
                indegree[next]--;
                if(indegree[next] == 0){
                    queue.add(next);
                }
            }
        }
//        if(cnt > n){
//            System.out.println(0);
//        }else{
//            System.out.println(sb.toString());
//        }
        for (int i = 1; i < n + 1; i++) {
            if(indegree[i] != 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(sb.toString());
//            System.out.println(sb.toString());


    }
}
