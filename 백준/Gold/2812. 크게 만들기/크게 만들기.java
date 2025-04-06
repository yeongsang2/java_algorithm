
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        boolean[] checked = new boolean[n];

        String str = br.readLine();
        for (int i = 0; i < n; i++) {
            arr[i] = Character.getNumericValue(str.charAt(i));
        }

        Stack<Integer> stack = new Stack();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int now = arr[i];
            if(count == k) break;
            while (!stack.isEmpty() && arr[stack.peek()] < now && count < k){
                Integer pop = stack.pop();
                checked[pop] = true;
                count++;
            }
            stack.add(i);
        }

        while(!stack.isEmpty() && count < k){
            Integer pop = stack.pop();
            checked[pop] = true;
            count++;
        }


        for (int i = 0; i < n; i++) {
            if(!checked[i]) System.out.print(arr[i]);
        }





    }
}
