package programmers;

import java.io.BufferedReader;
import java.util.HashSet;
import java.util.Set;

public class PocketMon {

    public static void main(String[] args) {
        Set set = new HashSet();
        int answer = 0;
        int[] nums = { 3,1,2,3 };
        for(int i=0; i< nums.length; i++){
            set.add(nums[i]);
        }
        if(set.size() > nums.length / 2){
            answer = nums.length / 2;
        }else {
            answer = set.size();
        }
        System.out.println(answer);
    }
}
