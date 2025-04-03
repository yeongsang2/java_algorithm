
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            Long num = Long.parseLong(br.readLine());
            pq.add(num);
        }

        if(n == 1){
            System.out.println(0);
            return;
        }

        long ans = 0;
        while (!pq.isEmpty()){

            long first = pq.poll();
            long next = pq.poll();
            long sum = first + next;
            ans += sum;
            if(!pq.isEmpty()){
                pq.add(sum);
            }
        }

        System.out.println(ans);

    }
}
