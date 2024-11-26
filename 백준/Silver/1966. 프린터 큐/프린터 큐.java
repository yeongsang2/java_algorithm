import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class MyPaper {
        int idx;
        int priority;
        public MyPaper(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 문서 수
            int m = Integer.parseInt(st.nextToken()); // 궁금한 문서 위치
            int[] priorityArr = new int[n+1];
            int answer = 0;

            Deque<MyPaper> queue = new ArrayDeque<>();
            Queue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new MyPaper(j, priority));
                priorityQueue.add(priority);
            }

            int cnt =0;
            while(!queue.isEmpty()){
                MyPaper poll = queue.poll();
                if(poll.priority >= priorityQueue.peek()){
                    cnt++;
                    priorityQueue.poll();
                    if(poll.idx == m){
                        answer = cnt;
                        break;
                    }
                }else{
                    queue.addLast(poll);
                }
            }
            System.out.println(answer);
        }
    }
}
