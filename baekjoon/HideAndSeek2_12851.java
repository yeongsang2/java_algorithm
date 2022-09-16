package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HideAndSeek2_12851 {

    public static int n,k;
    public static int cnt;
    public static int min = Integer.MAX_VALUE;
    public static int[] time = new int[100001];


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(min);
        System.out.println(cnt);

    }

    public static void bfs(){
        //시간대별로 체크? //bfs라는걸 명심하라능
        Queue<Integer> queue = new LinkedList();
        queue.add(n);
        time[n] = 1; // 초기화
        int next;

        while(!queue.isEmpty()) {

            Integer now = queue.poll();
            if(min < time[now]){
                return;
            }
            for (int i = 0; i < 3; i++) {

                if(i==0) next= now+1;
                else if(i==1) next= now-1;
                else next= now*2;

                if( next < 0 || next >100001) continue;

                if( next == k){ //잡았을경우
                    min = time[now];
                    cnt++;
                }

                //방문하지 않았거나 --> 0
                //같은경우
                if( time[next] == 0 || time[next] == time[now] +1){
                    queue.add(next);
                    time[next] = time[now] +1;
                }

            }
        }
    }
}

