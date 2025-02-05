import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });
        for(int i = 0; i < routes.length; i++){
            // System.out.println(routes[i][0] + " " + routes[i][1]);
        }
        
        int answer = 0;
        int cam = Integer.MIN_VALUE;
        for(int[] route : routes){
            int start = route[0];
            int end = route[1];
            if(start > cam){
                answer++;
                cam = end;
            }
        }
                
        
        return answer;
    }
}