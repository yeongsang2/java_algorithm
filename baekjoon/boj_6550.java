package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_6550 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String str = br.readLine();
            if(str == null){
                break;
            }
            StringTokenizer st = new StringTokenizer(str);
            String s = st.nextToken();
            String t = st.nextToken();
            Queue<Character> queue = new LinkedList<>();

            for (int i = 0; i < s.length(); i++) {
                queue.add(s.charAt(i));
            }

            Character now = queue.poll();
            System.out.println(t);
            for (int i = 0; i < t.length(); i++) {
                if(t.charAt(i) == now){
                    now = queue.poll();
                }
            }

            if(queue.size() == 0){
                sb.append("YES\n");
            }else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb.toString());
    }
}
