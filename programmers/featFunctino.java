package programmers;

import java.util.*;

public class featFunctino {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        List<Integer> answer = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add( (int) Math.ceil( ( 100.0 -  progresses[i] / speeds[i] )) );
        }
        while(!queue.isEmpty()){
            int day = queue.poll();
            int count = 1;
            while(!queue.isEmpty() && day >= queue.peek()){
                queue.poll();
                count++;
            }
            answer.add(count);
        }
//        return answer.stream().mapToInt(Integer::intValue).toArray();

    }
}
