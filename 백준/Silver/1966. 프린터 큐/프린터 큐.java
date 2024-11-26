
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Paper {
        int idx;
        int priority;
        public Paper(int idx, int priority) {
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
            int max = Integer.MIN_VALUE;
            int answer = 0;

            Deque<Paper> queue = new ArrayDeque<>();

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int priority = Integer.parseInt(st.nextToken());
                max = Math.max(max, priority);
                queue.add(new Paper(j, priority));
            }

            int cnt =1;
            while(!queue.isEmpty()){
                Paper now = queue.pollFirst();
                boolean tag = true;
                for(Paper p : queue){
                    if(now.priority < p.priority){
                        tag = false;
                        break;
                    }
                }
                if(tag){
                    if(now.idx == m){
                        answer = cnt;
                        break;
                    }
                    cnt++;
                }else{
                    queue.addLast(now);
                }
            }
            System.out.println(answer);
        }
    }
}
