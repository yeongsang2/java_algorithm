
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
        long[] answer = new long[100001];
        boolean[] checked = new boolean[100001];

        while(!queue.isEmpty()){

            Integer poll = queue.poll();
//            System.out.println(poll);
            if(poll == k){
                break;
            }
            // x+1
            if(poll + 1 < 100001 && !checked[poll+1]){
                answer[poll+1] = answer[poll] +1;
                queue.add(poll+1);
                checked[poll+1]= true;
            }
            // x*2
            if(poll * 2 < 100001 && !checked[poll*2]){
                answer[poll*2] = answer[poll] +1;
                queue.add(poll*2);
                checked[poll*2]= true;
            }
            if(poll > 0 && !checked[poll-1]){
                answer[poll-1] = answer[poll] +1;
                queue.add(poll-1);
                checked[poll-1]= true;
            }


        }
//        System.out.println();
        System.out.println(answer[k]);

    }
}
// 0 4
// 0 1 2 4
// 0 3
// 0 1 2 3
// 0 5
// 3 6 12 24 48 96
