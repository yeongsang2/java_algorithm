package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_2422 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();

        int n = Integer.parseInt(st.nextToken()); // 종류수
        int m = Integer.parseInt(st.nextToken());

        for (int i = 1; i < n+1; i++) {
            map.put(i, new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            map.get(a).add(b);
            map.get(b).add(a);
        }

        int answer =0;

        for (int i = 1; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n+1; k++) {
                    if(!map.get(i).contains(j) && !map.get(i).contains(k) && !map.get(j).contains(k)){
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
