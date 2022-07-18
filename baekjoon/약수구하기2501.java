package baekjoon;

import java.util.*;

public class 약수구하기2501 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int cnt =0;
        List<Integer> list = new ArrayList<>();

        for(int i=1; i <= n; i++){
            if (n % i == 0) {
                list.add(i);
                cnt ++;
            }
        }
        if(cnt < k){
            System.out.println(0);
        }else {
            System.out.println(list.get(k - 1));
        }
    }
}
