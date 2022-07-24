package baekjoon;

import javax.swing.*;
import java.util.Arrays;

public class 조합 {

    private static int arr[] = {1,2,3,4};
    private static int  n =4;  // nCr
    private static int r =2;
    private static int[] answer = new int[2];
    private static boolean[] isChecked = new boolean[4];

    public static void main(String[] args) {

        comb(0,0); //cnt값

    }

    private static void comb(int start, int cnt){


        if(cnt == 2){
            System.out.println(Arrays.toString(answer));
            return;
        }

        for(int i = start; i< 4;i++){
            answer[cnt] = arr[i];
            comb(i+1, cnt+1);
        }
    }
}
