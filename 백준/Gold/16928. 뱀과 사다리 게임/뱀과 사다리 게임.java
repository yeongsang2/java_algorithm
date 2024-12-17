
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] answer= new int[101];
    static int[] board = new int[101];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i < 101; i++) {
            board[i] = i;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a] = b;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            board[a] = b;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(now == 100){
                break;
            }
            for (int i = 1; i < 7; i++) {
                int next = now + i;
                if(next < 101){
                    int nextReal = board[next];
                    if(nextReal < 101 && answer[nextReal] ==0){
                        answer[nextReal]  = answer[now] +1;
                        queue.add(nextReal);
                    }
                }
            }
        }
        System.out.println(answer[100]);
    }
}
