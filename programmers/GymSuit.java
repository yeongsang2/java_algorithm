package programmers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GymSuit {
    public static void main(String[] args) {
//        solution();
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        //lost 순회
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < reserve.length ; i++) {
            set.add(reserve[i]);
        }
        for (int i = 0; i < lost.length; i++) {
            if(set.contains(lost[i])){
                set.remove(lost[i]);
                lost[i] = 0;
            }

        }
        for (int i = 0; i < lost.length; i++) {
            int l = lost[i];
            if(l > 1 && set.contains(l-1)){
                set.remove(l-1);
                lost[i] =0;
            } else if (set.contains(l+1)) {
                set.remove(l+1);
                lost[i] = 0;
            }
        }
        for (int i = 0; i < lost.length; i++) {
            if(lost[i] != 0){
                n--;
            }
        }
        return n;
    }
}
