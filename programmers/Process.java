package programmers;

import java.util.*;
import java.util.stream.Stream;

public class Process {
    public static void main(String[] args) {
        System.out.println(solution( new int[]{1, 1, 9, 1, 1, 1} , 0));
    }

    public static class Loc{
        int priority;
        int location; // check 1이면 나오는거;
        public Loc(int priority, int check){
            this.priority = priority;
            this.location = check;
        }
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Loc> queue = new LinkedList<>();
        int max = Arrays.stream(priorities).max().getAsInt();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Loc(priorities[i], i));
        }

        while(!queue.isEmpty()) {
            Loc poll = queue.poll();
            if(poll.location == location && poll.priority == max){
                answer ++;
                return answer;
            }
            if(poll.priority == max){
                answer++;
                priorities[poll.location] = 0;
                max = Arrays.stream(priorities).max().getAsInt();
                continue;
            }
            queue.add(poll);
        }
        return answer;
    }
}
