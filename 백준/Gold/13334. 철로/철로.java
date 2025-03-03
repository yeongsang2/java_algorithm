
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static class Pair implements Comparable<Pair> {
        int start;
        int end;
        public Pair(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<Pair> list = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int home = Integer.parseInt(st.nextToken());
            int work = Integer.parseInt(st.nextToken());

            int a = Math.min(home, work);
            int b = Math.max(home, work);
            list.add(new Pair(a,b));
        }
        int d = Integer.parseInt(br.readLine());

        Collections.sort(list);

        // 시작점을 담아두는 우선순위 큐
        // 우선순위큐가 현재 범위 안에 들어가는 사이즈의 수
        // 시작점을 기준으로 우선순위큐
        // 현재값의 start보다 낮은 시작점을 가지는 우선순위큐들은 삭제
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int answer = 0;
        for(Pair pair : list){
            int start = pair.start;
            int end = pair.end;

            // 현재값의 start보다 낮은 시작점을 가지는 우선순위큐들 삭제
            while(!pq.isEmpty() && pq.peek() < end - d ){
                pq.poll();
            }
            // 범위 안에 들어가면 우선수위큐에 넣어줌
            if( start >= end - d){
                pq.add(start);
            }

            answer = Math.max(answer, pq.size());
        }
        System.out.println(answer);
    }
}
