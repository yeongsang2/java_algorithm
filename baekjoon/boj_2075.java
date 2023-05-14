package baekjoon;
import java.io.*;
import java.util.Collections;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class boj_2075 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new PriorityQueue(Collections.reverseOrder());


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n ; j++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < n -1 ; i++) {
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
