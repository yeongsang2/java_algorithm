package programmers;

import java.util.*;

public class ChoiceGuel {

    public static void main(String[] args) {

        Map<Integer, Integer> hashMap = new HashMap();
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        int answer = 0;
        int k = 6;
        for(int i =0 ;i < tangerine.length; i++){
            int t = tangerine[i];
            if(hashMap.containsKey(t)){
                Integer h = hashMap.get(t);
                hashMap.put(t, h+1);
            }else{
                hashMap.put(t, 1);
            }
        }

        List<Integer> list = new ArrayList<>(hashMap.keySet());

        Collections.sort(list, (value1, value2) -> (hashMap.get(value2).compareTo(hashMap.get(value1))));

        for(Integer key : list) {
            System.out.println("key : " + key + " , " + "value : " + hashMap.get(key));
            if(k - hashMap.get(key) <= 0 ){
                answer++;
                System.out.println(answer);
                break;
            }else{
                k = k - hashMap.get(key);
                answer++;
            }
        }
    }
}
