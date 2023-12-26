package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.PriorityQueue;

public class boj_7662 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;
        int n =  Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            PriorityQueue<Integer> priorityQueueA = new PriorityQueue<>();
            PriorityQueue<Integer> priorityQueueB = new PriorityQueue<>(Collections.reverseOrder());
            int t = Integer.parseInt(br.readLine());

            for (int j = 0; j < t; j++) {

                st = new StringTokenizer(br.readLine());

                String operation = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                // insert
                if(operation.equals("I")){
                    priorityQueueA.add(num);
                    priorityQueueB.add(num);
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }else{
                    //delete
                    //비어있음
                    if(map.size() == 0){
                        continue;
                    }

                    if(num == 1){ //최대
                        removeMap(priorityQueueB, map);
                    }else {
                        removeMap(priorityQueueA, map); // 최소
                    }

                }
            }

            if(map.size() == 0){
                sb.append("EMPTY");
            }else {
                int numb = removeMap(priorityQueueB, map);
                sb.append(numb).append(" ").append(map.size() > 0 ? removeMap(priorityQueueA, map) : numb);
            }
            sb.append("\n");

        }
        System.out.println(sb.toString());

    }

    public static int removeMap(PriorityQueue<Integer> queue, Map<Integer,Integer> map){
        int poll;
        while(true){
            poll = queue.poll();
            Integer number = map.getOrDefault(poll, 0);
            if(number ==0){ // 존재 x
                continue;
            }

            if(number == 1){
                map.remove(poll);
            }else {
                map.put(poll, number -1);
            }
            break;
        }
        return poll;
    }
}
