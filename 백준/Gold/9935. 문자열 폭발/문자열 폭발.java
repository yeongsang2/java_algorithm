
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] strArr = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();
        int targetLength = target.length;


//        String temp = Character.toString(strArr[0]);
        Stack<Character> stack = new Stack<>();
//        stack.add(strArr[0]);
        for (int i = 0; i < strArr.length; i++) {
            char now = strArr[i];
            stack.add(now);

            if(stack.size() >= targetLength){ // 길이가 일치하면 탐색
                boolean flag = true;
                for (int j = 0; j < targetLength; j++) {
                    if(target[j] != stack.get(stack.size() - targetLength + j) ){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for (int j = 0; j < targetLength; j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(Character c : stack){
            sb.append(c);
        }
        if(sb.length() ==0){
            System.out.println("FRULA");
        }else{
            System.out.println(sb);
        }
    }
}
