package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_5568 {

    static int[] cardArr;
    static int n;
    static int k;
    static Set<Integer> answerSet = new HashSet<>();
    public static void main(String[] args) throws IOException {
        // 만들 수 있는 정수의 개수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        cardArr = new int[n];
        for (int i = 0; i < n; i++) {
            cardArr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < n; i++) {
            Set<Integer> set = new LinkedHashSet<>();
            set.add(i);
            search(set);
            set.remove(i);
        }
        System.out.println(answerSet.size());
    }
    static void search(Set<Integer> path){

        if(path.size() == k){
            String s = "";
            for(Integer i  : path){
                Integer number = cardArr[i];
                s += number.toString();
            }
            answerSet.add(Integer.parseInt(s));
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!path.contains(i)){
                path.add(i);
                search(path);
                path.remove(i);
            }
        }
    }
}
