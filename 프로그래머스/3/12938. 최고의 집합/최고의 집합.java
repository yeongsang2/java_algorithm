import java.util.*;

class Solution {
    
    static List<Integer> list = new LinkedList();
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        if(n > s){
            return new int[]{-1};
        }else {
            int q = s / n;
            int remain = s % n;
            Arrays.fill(answer, q);
            for(int i =0 ; i < remain ; i++){
                answer[i]++;
            }
            Arrays.sort(answer);
        }
        
        return answer;
    }
}