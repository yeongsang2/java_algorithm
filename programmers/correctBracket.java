package programmers;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import static java.lang.System.exit;

public class correctBracket {
    public static void main(String[] args) {
        System.out.println(solution("()()"));
        }
    public static boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        if(s.length() == 1){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && s.charAt(i) == ')'){
                stack.pop();
                continue;
            }
            stack.add(s.charAt(i));
        }

        if(!stack.isEmpty()){
            answer = false;
        }

        return answer;
    }
}
