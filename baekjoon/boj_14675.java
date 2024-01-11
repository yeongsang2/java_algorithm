package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_14675 {

    static int n;
    static List<List<Integer>> nodeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n + 1; i++) {
            nodeList.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            nodeList.get(a).add(b); //양 방향 연결
            nodeList.get(b).add(a);
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {

            st = new StringTokenizer(br.readLine());
            int opt = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if(opt == 1){ // 단절점
                if(nodeList.get(num).size() == 1 ){
                    sb.append("no");
                }else{
                    sb.append("yes");
                }

            }else{ // 단전설
                sb.append("yes");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
//    1 - 2 - 3 - 4 - 5
    // 문제의 정답 조건을 먼저 파악해볼것

}
