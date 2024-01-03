package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class boj_1174 {

    static int n;
    static int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
    static List<Long> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dfs(0,0);
        list.sort(null);
        try {
            System.out.println(list.get(n-1));
        } catch (Exception e){
            System.out.println(-1);
        }
    }

    static void dfs(long num, int idx){

        if(!list.contains(num)){
            list.add(num);
        }

        if(idx >= 10){
            return;
        }

        dfs((num * 10 + arr[idx] ), idx+1 );
        dfs(num, idx + 1 );

    }
}
