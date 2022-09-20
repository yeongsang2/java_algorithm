package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class HideAndSeek4 {

    public static int n, k;

    public static int[] time = new int[100001];
    public static int[] loc = new int[100001]; //이전위치를 담는 배열  n부터 k까지의
    int ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k) {
            System.out.println(0);
            System.out.println(n);
        } else {
            bfs();

            System.out.println(time[k] - 1);
            Stack<Integer> stack = new Stack<>();
            stack.push(k);
            int index = k;
            while (index != n) {
                stack.push(loc[index]);
                index = loc[index];
            }
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }


    public static void bfs(){

        time[n] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int next;
        while(!queue.isEmpty()){

            int now = queue.poll();

            if(now == k){
                return;
            }
            for(int i=0; i<3; i++){

                if(i == 0) next = now -1;
                else if(i == 1)next = now +1;
                else next = now *2;

                if( next < 0 || next > 100000) continue;

                if( time[next] == 0){
                    queue.add(next);
                    time[next] = time[now] +1;
                    loc[next] = now;
                }
            }


        }
    }

}
