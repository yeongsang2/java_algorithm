package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_prev1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer>[] arr = new List[10001];

        for (int i = 1; i < n+1; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 1
            // 2  3
            // 4  5  6
            // 7  8(a)  9  10
            // 11 12 13 14 15
            // 16 17 18 19 20 21
            //
            int small = Math.min(a,b);
            int big = Math.max(a,b);

            for (int j = 0; j < big + 1; j++) {
                arr[j] = new ArrayList();
            }
            int grow = 1;
            int count= 1;
            for (int j = 1; j < big + 1; j++) {

                if(count != grow){
                    arr[j].add(j-1);
                    arr[j-1].add(j);
                }
                arr[j].add(j+grow);
                arr[j].add(j+grow+1);

                count--;
                if(count == 0){
                    grow++;
                    count = grow;
                }
            }

            int[] map  = new int[10001];
            boolean[] visited = new boolean[10001];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(small);

            while(!queue.isEmpty()){

                Integer poll = queue.poll();
                visited[poll] = true;
                if(poll == big){
                    break;
                }
                for (Integer integer : arr[poll]) {
                    if ( integer < big+1 && !visited[integer] && map[integer] == 0) {
                        queue.add(integer);
                        map[integer] = map[poll] + 1;
                    }
                }
            }
            sb.append("#").append(i).append(" ").append(map[big]).append("\n");

        }
        System.out.println(sb.toString());
    }

}
