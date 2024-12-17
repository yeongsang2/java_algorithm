
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            Integer b = Integer.parseInt(st.nextToken());

            Queue<Integer> queue = new LinkedList<>();
            queue.add(Integer.parseInt(a));
            boolean[] visited = new boolean[10000];
            String[] command = new String[10000];
            visited[Integer.parseInt(a)] = true;
            Arrays.fill(command, "");

            while(!queue.isEmpty() && !visited[b]){

                int now = queue.poll();

                //D
                Integer dValue = ( now * 2 ) % 10000;
                if(!visited[dValue]) {
                    visited[dValue] = true;
                    command[dValue] = command[now] + "D";
                    queue.add(dValue);
                }

                //S
                Integer sValue;
                if(now == 0){
                    sValue = 9999;
                }else{
                    sValue = now-1;
                }
                if(!visited[sValue]) {
                    visited[sValue] = true;
                    command[sValue] = command[now] + "S";
                    queue.add(sValue);
                }
                //L
                Integer lValue = ( now % 1000)*10 + (now / 1000);
                if(!visited[lValue]) {
                    visited[lValue] = true;
                    command[lValue] = command[now] + "L";
                    queue.add(lValue);
                }

                //R
                Integer rValue = (now % 10) * 1000 + (now / 10);
                if(!visited[rValue]){
                    visited[rValue] = true;
                    command[rValue] = command[now] + "R";
                    queue.add(rValue);
                }
            }
            System.out.println(command[b]);
        }



    }
}
