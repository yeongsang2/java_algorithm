import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        Stack<Integer> stack = new Stack<>();
        int point = 1;
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            if( now == point ) {
                point++;
                while(!stack.isEmpty() && stack.peek() == point){
                    stack.pop();
                    point++;
                }
            }else {
                stack.add(now);
            }
        }

        if(!stack.isEmpty()){
            System.out.println("Sad");
        }else{
            System.out.println("Nice");
        }
    }
}
