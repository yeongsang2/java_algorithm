package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_21939 {

    static class Problem implements Comparable<Problem>{
        int l;
        int p;
        public Problem(int l, int p){
            this.l = l;
            this.p = p;
        }

        public int compareTo(Problem o){
            if(this.l == o.l){
                return p - o.p;
            }
            return l - o.l;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n  = Integer.parseInt(br.readLine());

        TreeSet<Problem> treeSet = new TreeSet<>();
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            Problem problem = new Problem(l, p);
            treeSet.add(problem);
            map.put(p,l); //추천문제리스틋

        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String opt = st.nextToken();

            if(opt.equals("add")){
                int p = Integer.parseInt(st.nextToken());
                int l = Integer.parseInt(st.nextToken());

                treeSet.add(new Problem(l,p));
                map.put(p,l);
            }else if(opt.equals("recommend")){

                int o = Integer.parseInt(st.nextToken());
                if(o == 1){ // 최대
                    Problem last = treeSet.last();
                    sb.append(last.p).append("\n");
                }else{
                    Problem first = treeSet.first();
                    sb.append(first.p).append("\n");

                }
            }else{ //solved
                int p = Integer.parseInt(st.nextToken());
                int l = map.get(p);
                map.remove(p);
                treeSet.remove(new Problem(l,p));
            }
        }
        System.out.println(sb.toString());
    }
}
