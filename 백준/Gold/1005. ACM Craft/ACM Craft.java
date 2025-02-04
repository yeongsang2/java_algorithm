
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t= Integer.parseInt(br.readLine());

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] costArr = new int[n + 1];
            List<List<Integer>> list = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < n + 1; i++) {
                costArr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n + 1; i++) {
                list.add(new LinkedList<>());
            }   

            int[] indegree = new int[n + 1];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                list.get(start).add(end);
                indegree[end]++;
            }
            int last = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            int[] answerArr = new int[n+1];

            for (int i = 1; i < n+1; i++) {
                answerArr[i] = costArr[i];
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()){
                Integer poll = queue.poll();
                for(Integer now: list.get(poll)){
                    answerArr[now] = Math.max(answerArr[now], answerArr[poll] + costArr[now]);
                    indegree[now]--;

                    if(indegree[now] == 0){
                        queue.add(now);
                    }
                }
            }
            System.out.println(answerArr[last]);
        }
    }
}
