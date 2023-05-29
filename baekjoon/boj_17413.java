package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj_17413 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack();
        Stack<Character> check = new Stack<>();
        boolean tag = false;

        for(int i=0 ; i <str.length(); i++){

            if (str.charAt(i) == '<'){
                if(stack.isEmpty()){
                    sb.append(str.charAt(i));
                    tag = true;
                    continue;
                }else {
                    while(!stack.isEmpty()){
                        sb.append(stack.pop());
                    }
                    sb.append(str.charAt(i));
                    tag = true;
                }
                continue;
            }

            if( str.charAt(i) == '>'){
                sb.append(str.charAt(i));
                tag = false;
                continue;
            }
            if ( str.charAt(i) == ' ' && (tag ==false)){
                while(!stack.isEmpty()){
                    sb.append(stack.pop());
                }
                sb.append(' ');
                continue;
            }

            if( tag ==true){
                sb.append(str.charAt(i));
                continue;
            }
            stack.add(str.charAt(i));
        }


        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }


        System.out.println(sb);
    }
}
