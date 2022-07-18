package baekjoon;

import java.util.*;

public class N번째큰수_2693 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        int[] arr = new int[10];
        for(int i =0 ; i< t ;i ++){
            for(int j =0; j < 10; j++){
                arr[j] = sc.nextInt();
            }
            Arrays.sort(arr);
            System.out.println(arr[7]);
        }
    }
}
