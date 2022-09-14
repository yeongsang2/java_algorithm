package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AtoB_16953 {

        public static long a,b;
        public static boolean state = false;
        public static long ans = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Long.parseLong(st.nextToken());
        b = Long.parseLong(st.nextToken());

        dfs(a, 0);

        if(state) {
            System.out.println(ans+1);
        }else {
            System.out.println(-1);
        }
    }

    public static void dfs(long a, long depth){

        if(a == b){
            state  = true;
            ans = Math.min(ans, depth);
        }

        long aa = a*2;

        String s = Long.toString(a) + "1";

//        System.out.println(s);
        long a1 = Long.parseLong(s);

        if(aa <= b){
            dfs(aa, depth+1);
        }

        if(a1 <= b){
            dfs(a1, depth+1);
        }

    }

}
