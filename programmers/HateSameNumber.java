package programmers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

public class HateSameNumber {

    public static void main(String[] args) {

        int[] arr = { 1,1,3,3,0,1,1	};
        int[] answer = {};
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if(stack.peek() != arr[i]){
                stack.add(arr[i]);
            }
        }
        answer = new int[stack.size()];
        for (int i : stack){
            answer[count] = i;
            count++;
        }
        return answer;

    }
}
