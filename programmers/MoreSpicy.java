package programmers;

import java.util.PriorityQueue;

public class MoreSpicy {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{ 1, 2, 3, 9, 10, 12	}, 7));
    }
    public static int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < scoville.length; i++) {
            priorityQueue.add(scoville[i]);
        }

        while (true){
            if (priorityQueue.peek() >= K){
                return answer;
            }
            if (priorityQueue.size() < 2) {
                return -1;
            }
            priorityQueue.add(priorityQueue.poll() + (priorityQueue.poll()*2));
            answer++;
        }
    }
}
