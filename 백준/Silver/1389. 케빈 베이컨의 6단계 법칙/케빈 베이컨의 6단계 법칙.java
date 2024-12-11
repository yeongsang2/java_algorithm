
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //친구수
        int m = Integer.parseInt(st.nextToken()); //관계수

        List<List<Integer>> list = new LinkedList<>();

        for (int i = 0; i < n+1; i++) {
            list.add(new LinkedList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int[][] answer = new int[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            int count =0;
            boolean[] checked = new boolean[n+1];
            checked[i] = true;
            while(!queue.isEmpty()){
                Integer poll = queue.poll();
                for(Integer now : list.get(poll)) {
                    if(!checked[now]){
                        checked[now] = true;
                        queue.add(now);
                        answer[i][now] = answer[i][poll] +1;
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        int ansNum = -1;
        for (int i = 1; i < n+1; i++) {
            int temp = 0;
            for (int j = 1; j < n+1; j++) {
//                System.out.print(answer[i][j] + " ");
                temp += answer[i][j];
            }
//            System.out.println();
            if(temp < ans){
                ans = temp;
                ansNum = i;
            }
        }
        System.out.println(ansNum);

    }
}
