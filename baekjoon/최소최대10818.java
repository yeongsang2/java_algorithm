package baekjoon;

import java.util.*;

public class 최소최대10818 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            list.add(sc.nextInt());
        }
        System.out.println(Collections.min(list) + " " + Collections.max(list));
    }
}
