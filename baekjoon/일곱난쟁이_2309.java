package baekjoon;

import java.util.*;

public class 일곱난쟁이_2309 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int[] arr= new int[9];
        int sum=0;
        for(int i=0; i<9;i ++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        int spyA =0;
        int spyB =0;
        Arrays.sort(arr);

        for(int i=0; i< arr.length-1; i++){
            for(int j= i +1 ; j < arr.length; j++){
                if( (sum - arr[i] - arr[j]) == 100 ){
                    spyA = arr[i];
                    spyB = arr[j];
                }
            }

        }
        for(int i=0; i< arr.length; i++){
            if( arr[i] == spyA || arr[i] == spyB){
                continue;
            }System.out.println(arr[i]);

        }

    }
}
