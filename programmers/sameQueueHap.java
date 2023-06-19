package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class sameQueueHap {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1}));
    }
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> pq1= new LinkedList<>();
        Queue<Integer> pq2= new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(Integer i : queue1){
            pq1.offer(i);
            sum1+= i;
        }
        for(Integer i : queue2){
            pq2.offer(i);
            sum2+= i;
        }
        while(sum1 != sum2){
            if ( answer > (queue1.length + queue2.length) * 2){
                return -1;
            }
            answer++;
            System.out.println(sum1);
            System.out.println(sum2);
            //작은쪽에서 poll
            if(sum1 > sum2 ){
                int poll = pq1.poll();
                pq2.offer(poll);
                sum1 -= poll;
                sum2 += poll;
            }else if ( sum1 < sum2 ){
                int poll = pq2.poll();
                pq1.offer(poll);
                sum1 += poll;
                sum2 -= poll;
            }
        }
        return answer;
    }
}
