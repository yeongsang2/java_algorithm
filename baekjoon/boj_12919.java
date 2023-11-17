package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_12919 {

    static String s;
    static String t;
    static int flag = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<String> list = new LinkedList<>();

        s = br.readLine();
        t = br.readLine();

        dfs(t);
        System.out.println(flag);

    }
    static void dfs(String str){

        if(str.length() == s.length()){
            if(s.equals(str)){
                System.out.println(1);
                System.exit(0);
            }
            return;
        }
        //A방법
        // t에서 단순히 뒤에서 A 제거

        if(str.charAt(0) == 'B' ) {
            //B방법
            String nStrB = new String();
            for (int i = str.length() - 1; i >= 0; i--) {
                nStrB = nStrB + str.charAt(i);
            }
            nStrB = nStrB.substring(0, nStrB.length() - 1);
            dfs(nStrB);
        }
        if(str.charAt(str.length() - 1) == 'A'){
            String nStrA = new String(str);
            nStrA = nStrA.substring(0, nStrA.length() -1);

            dfs(nStrA);
        }

    }
}
