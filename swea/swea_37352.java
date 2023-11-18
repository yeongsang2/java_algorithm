package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class swea_37352 {

    static int n;
    static int[] board;
    static Set set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=  new StringBuilder();

        int t= Integer.parseInt(br.readLine());

        for (int i = 1; i < t+1; i++) {
            n  =  Integer.parseInt(br.readLine());
            board = new int[n];
            set = new HashSet();
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                board[j] = Integer.parseInt(st.nextToken());
            }
            set.add(0);
            for (int j = 0; j < n; j++) {
                int score = board[j];
                sum(score);
            }
            sb.append("#").append(i).append(" ").append(set.size()).append("\n");
        }
        System.out.println(sb.toString());
    }
    static void sum(int score){

        Set<Integer> tmpSet = new HashSet<Integer>();
        tmpSet.addAll(set);

        Iterator<Integer> it = tmpSet.iterator();
        while (it.hasNext()){
            set.add(it.next() + score);
        }
    }
//    public static void dfs(int idx, int sum){
//
//        for (int i = idx +1; i < n; i++) {
//            if( !list.contains(sum+board[i]) ){
//                list.add(sum+board[i]);
//                dfs(i, sum + board[i]);
//            }
//        }
//    }
}
