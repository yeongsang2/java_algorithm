package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class boj_2346 {

    static class Balloon{
        int idx; // 번호
        int content; // 내용

        public Balloon(int idx, int content){
            this.idx = idx;
            this.content = content;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        Deque<Balloon> deque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < num; i++) {
            int con = Integer.parseInt(st.nextToken());
            deque.add(new Balloon(i+1, con));
        }

        for (int i = 0; i < num; i++) {

            Balloon balloon = deque.poll();
            sb.append(Integer.toString(balloon.idx)  + " ");

            if(deque.isEmpty()){
                break;
            }

            if (balloon.content > 0){ // 양수
                for (int j = 0; j < balloon.content -1 ; j++) {
                    deque.addLast(deque.poll());
                }
            } else{
                int b = Math.abs(balloon.content);
                for (int j = 0; j < b ; j++) {
                    deque.addFirst(deque.pollLast());
                }
            }
        }

        System.out.println(sb.toString());
    }
}