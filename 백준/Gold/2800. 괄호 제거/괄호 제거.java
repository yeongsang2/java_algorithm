import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Set<String> set = new TreeSet<>();
    static int[] pair;
    static char[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Integer> stack = new Stack<>();
        arr = str.toCharArray();
        pair = new int[str.length()];
        visit = new boolean[str.length()];

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '('){
                stack.add(i);
            }else if(arr[i] == ')'){
                Integer peek = stack.peek();
                pair[i] = peek;
                pair[stack.peek()] = i;
                stack.pop();
            }
        }

        dfs(0, arr.length);
        set.remove(str);

        for(String s : set){
            System.out.println(s);
        }

    }
    static void dfs(int idx, int length){
        if(idx == length){
            String s = "";
            for (int i = 0; i < length; i++) {
                if(!visit[i]){
                    s +=  arr[i];
                }
            }
            set.add(s);
            //
            return;
        }

        if(arr[idx] == '('){
            visit[idx] = true;
            visit[pair[idx]] = true;

            dfs(idx+1, length);

            visit[idx] = false;
            visit[pair[idx]] = false;
        }
        dfs(idx+1, length);
    }
}
