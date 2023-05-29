package programmers;

import java.util.HashSet;
import java.util.Set;

public class Lotto {
    public static void main(String[] args) {


    }
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer;
        int zeroCnt= 0;
        int cnt= 0;
        Set<Integer> set= new HashSet<>();
        for(int l : lottos){
            set.add(l);
            if(l == 0){
                zeroCnt++;
            }
        }
        if(zeroCnt == 6){
            answer = new int[]{1, 6};
            return answer;
        }

        for(int w : win_nums){
            if(set.contains(w)){
                cnt++;
            }
        }

        int low = 7 - cnt;
        int high = 7 - cnt - zeroCnt;
        if(low == 7){
            low = 6;
        }
        if(high ==7){
            low =6;
        }
        if(high < 1 ){
            high =1;
        }

        answer = new int[]{high, low};
        return answer;
    }
}
