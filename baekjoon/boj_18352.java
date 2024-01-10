package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_18352 {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Integer, List<Integer>> map = new HashMap<>();

        int n =Integer.parseInt(st.nextToken()); // 도시 개수
        int m =Integer.parseInt(st.nextToken());  // 도로 개수
        int k = Integer.parseInt(st.nextToken()); //거리정보
        int x = Integer.parseInt(st.nextToken()); // 출발도시

        for (int i = 1; i < m+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(map.containsKey(a)){
                map.get(a).add(b);
            }else{
                map.put(a, new ArrayList<>());
                map.get(a).add(b);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        int[] visited = new int[n+1];

        queue.add(x);
        while(!queue.isEmpty()){

            int size = queue.size();
            while(size-- > 0) {
                Integer poll = queue.poll();

                if(map.containsKey(poll)) {
                    for (Integer i : map.get(poll)) {
                        if (visited[i] == 0 && (i != x)) {
                            visited[i] = visited[poll] + 1;
                            queue.add(i);
                        } else {
                            visited[i] = Math.min(visited[i], visited[poll] + 1);
                        }
                    }
                }
            }
        }

        for (int i = 1; i < n+1; i++) {
            if(visited[i] == k){
                answerList.add(i);
            }
        }

        if(answerList.isEmpty()){
            System.out.println("-1");
        }else{
            Collections.sort(answerList);
            for(Integer i : answerList){
                System.out.println(i);
            }
        }
    }
}
