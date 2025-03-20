import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        
        Set<String> set = new HashSet();
        for(String s : gems){
            set.add(s);
        }
        int size = set.size();
        
        Map<String, Integer> map= new HashMap();
        
        int left = 0;
        int right = 0;
        int min = 100001;
        int leftIdx = 0;
        int rightIdx = 0;
        int length = gems.length;
        
        while(right < length){
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            right++;
            
            while(map.size() == set.size()){ //같을떄까지
                if(right - left < min){
                    min = right - left;
                    leftIdx = left + 1;
                    rightIdx = right;
                }
                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }
                left++;
                
            }
        }
        
        int[] answer = {leftIdx, rightIdx};
        
        return answer;
    }
}