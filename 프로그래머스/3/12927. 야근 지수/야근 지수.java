import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works){
            pq.add(w);
        }
        
        boolean flag = false;
        for(int i = 0; i < n ; i++){
            int num = pq.poll();
            if(num == 0){
                flag = true;
                break;
            }
            pq.add(--num);            
        }
        
        long answer = 0;
        while(!pq.isEmpty()){
            int temp = pq.poll();    
            answer += temp*temp;
        }
        
        return answer;
    }
}