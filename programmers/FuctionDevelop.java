package programmers;
import java.util.*;
public class FuctionDevelop {

    public static void main(String[] args) {
        int[] answer = Solution.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        for(int a : answer){
            System.out.println(a);
        }
    }

    static private class Solution {
            static public int[] solution(int[] progresses, int[] speeds) {
                List<Integer> list = new LinkedList();

                // int[] days = new int[progresses.length];
                Queue<Integer> queue = new LinkedList();

                int point = 0;
                for(int i= 0; i <progresses.length; i++){
                    int day = (int)Math.ceil( (100.0 - progresses[i] ) / speeds[i] );
                    queue.add(day);
                }

                while(!queue.isEmpty()){
                    int now = queue.poll();
                    int count = 1;
                    while(queue.peek() <= now && !queue.isEmpty()){
                        count++;
                        queue.poll();
                    }
                    list.add(count);
                }

                int[] answer = new int[list.size()];
                for(int i = 0; i < answer.length; i++){
                    answer[i] = list.get(i);
                }

                // 7일 3일 10일
                // 5일 10일 1일 1일 20일 1일
                return answer;
            }
        }
}

