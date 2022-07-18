package baekjoon;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class 쉽게푸는문제_1292 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt();
        int b= sc.nextInt();
        int n =1;
        List<Integer> list= new ArrayList<>();
        while(list.size() < b){
            for(int i = 0; i< n; i++){
                if(list.size() == b)
                    break;
                list.add(n);
            }
            n++;
        }
        int sum = 0;
        for(int i= a-1; i < b; i++){
            sum += list.get(i);
        }
        System.out.println(sum);
    }
}
