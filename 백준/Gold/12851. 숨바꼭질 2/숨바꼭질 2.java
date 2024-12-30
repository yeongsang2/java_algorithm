import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        queue.add(n);
        boolean[] visited = new boolean[100001];

        int answer = 0;
        int cnt = 0;
        boolean flag = false;
        while (!queue.isEmpty() && !flag){
            int size = queue.size();

            while (size-- > 0 && !queue.isEmpty()){
                Integer now = queue.poll();
                visited[now] = true;
//                System.out.print(now + " ");
                if(now == k){
                    cnt++;
                    flag = true;
                }

                if(now -1 >= 0 && !visited[now-1]){
                    queue.add(now-1);
                }
                if(now +1 < 100001 && !visited[now+1]){
                    queue.add(now+1);
                }
                if(2*now < 100001 && !visited[2*now]){
                    queue.add(2*now);
                }
            }
            answer++;
//            System.out.println();
        }
        System.out.println(answer-1);
        System.out.println(cnt);

    }
}
