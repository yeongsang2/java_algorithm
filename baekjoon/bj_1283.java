package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class bj_1283 {

    static Set<Character> set = new HashSet();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] strArr = br.readLine().split(" ");
            search(strArr);
        }
        System.out.println(sb.toString());
    }

    static void search(String[] strArr){

        boolean checked = false;
        Character temp = '1';
        int line = -1;
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i].toLowerCase();
            if(!set.contains(str.charAt(0)) && !checked){
                set.add(str.charAt(0));
                checked = true;
                temp = strArr[i].charAt(0);
                line = i;
                break;
            }
        }
        if(!checked){
            for (int i = 0; i < strArr.length; i++) {
                String str = strArr[i].toLowerCase();
                for (int j = 0; j < str.length(); j++) {
                    Character c = str.charAt(j);
                    if(!set.contains(c) && !checked){
                        set.add(c);
                        checked = true;
                        temp = strArr[i].charAt(j);
                        line = i;
                        break;
                    }
                }
            }
        }

        boolean point = false;
        for (int i = 0; i < strArr.length; i++) {
            String str = strArr[i];
            for (int j = 0; j < str.length(); j++) {
                Character c = str.charAt(j);
                if ( c == temp && line == i && !point){
                    sb.append("[").append(c).append("]");
                    point = true;
                }else {
                    sb.append(c);
                }
            }
            sb.append(" ");
        }
        sb.append("\n");
    }
}
