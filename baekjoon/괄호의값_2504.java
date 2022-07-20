package baekjoon;

import java.io.*;
import java.util.*;

public class 괄호의값_2504 {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stk = new Stack();

        int result =0;
        int mul = 1;
        int r = 1;

        for(int i=0; i< str.length(); i++){
            char cur = str.charAt(i);

            if(cur == '('){
                stk.push(cur);
                mul*=2;

            }else if(cur == '['){
                stk.push(cur);
                mul*=3;

            }else if(cur == ']'){
                if(stk.empty() || stk.peek() != '['){ //or
                    r = 0;
                    break;
                }
                if(str.charAt(i-1) =='[') {
                     result += mul;
                }
                stk.pop();
                mul /= 3;

            }else if(cur == ')'){
                if(stk.empty() || stk.peek() != '('){ //or
                    r = 0;
                    break;
                }
                if(str.charAt(i-1) =='(') {
                    result += mul;
                }
                stk.pop();
                mul /= 2;

            }
        }


        if(r == 1 || !stk.isEmpty()){
            System.out.println(result);
        }else {
            System.out.println(0);
        }
    }

}
