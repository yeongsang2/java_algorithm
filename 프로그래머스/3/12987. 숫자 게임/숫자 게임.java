import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        
        Arrays.sort(B);
        Arrays.sort(A);
        
        int answer = 0;
        int idx = 0;
        for(int a : A){
            
            while(idx < B.length && a >= B[idx]){
                idx++;
            }
            
            if(idx == B.length) break;
            
            answer++;
            idx++;
        }
        return answer;
    }
}