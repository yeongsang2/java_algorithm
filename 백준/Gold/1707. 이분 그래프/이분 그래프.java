
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {


    static int[] colors;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());

        while (K-- > 0){
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            List<List<Integer>> list = new ArrayList<>();
            colors = new int[v + 1];
            for (int i = 0; i < v + 1; i++) {
                list.add(new ArrayList<>());
            }

            boolean flag = true;
            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list.get(a).add(b);
                list.get(b).add(a);
            }

            for(int i = 1 ; i < v + 1 ; i++){
                if(colors[i] == 0){ //0이면
                    if(!isDigitGraph(list, i, 1)){
                        flag = false;
                        break;
                    }
                }
            }

            if(flag) sb.append("YES");
            else sb.append("NO");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static boolean isDigitGraph(List<List<Integer>> list, int node, int color){


        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        colors[node] = color;

        while (!queue.isEmpty()){
            Integer poll = queue.poll();

            for(int i : list.get(poll)){
                if(colors[i] == colors[poll]) return false;
                if(colors[i] == 0){
                    colors[i] = colors[poll] * - 1;
                    queue.add(i);
                }
            }
        }

        return true;
    }
}
