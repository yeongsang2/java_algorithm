package programmers;

import java.util.HashMap;

public class clothes {
    public static void main(String[] args) {


    }
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap();
        for(int i =0 ;i <clothes.length ; i ++){
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        int temp =1;
        for(String s : map.keySet()){
            temp = temp* (map.get(s) +1 );
        }
        answer =temp -1 ;
        return answer;
    }
}
