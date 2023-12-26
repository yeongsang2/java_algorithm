package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < n; i++) {

            Stack<Character> stack = new Stack<>();
            String str = br.readLine();
            stack.add(str.charAt(0));

            for (int j = 1; j < str.length(); j++) {
                if(!stack.isEmpty()) {
                    if (stack.peek() == str.charAt(j)) {
                        stack.pop();
                    } else {
                        stack.add(str.charAt(j));
                    }
                }else {
                    stack.add(str.charAt(j));
                }
            }

            if(stack.empty()){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
