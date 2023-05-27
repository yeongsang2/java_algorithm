package programmers;

import java.util.Arrays;
import java.util.Collections;

public class immigration {
    public static void main(String[] args) {

        System.out.println(solution(6, new int[]{7,10}));
    }

    public static long solution(int n, int[] times) {
        long answer;
        Arrays.sort(times);
        long max = (long)times[times.length- 1] * n;
        long min = 0;
        answer = max;
        while(min <= max){

            long mid =  ( max + min ) / 2;
            long sum = 0;
            for(int time : times){
                sum += mid / time;
            }
            // 10 명 나왔으면
            if ( sum >= n ){
                answer = mid;
                max = mid -1;
            }else{
                min = mid +1;
            }
        }

        return answer;
    }
}
