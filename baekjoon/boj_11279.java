package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class boj_11279 {

    public static void main(String[] args) throws IOException {
        Queue<Integer> queue = new PriorityQueue(Collections.reverseOrder());
        // x가 자연수 배열에 x추가
        // x가 0이면 배열에서 가장 큰 값 출력, 제거 /
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if ( x == 0){
                if(queue.isEmpty()){
                    System.out.println(0);
                }else {
                    Integer poll = queue.poll();
                    System.out.println(poll);
                }
            }else {
               queue.add(x);
            }
        }
    }
}
