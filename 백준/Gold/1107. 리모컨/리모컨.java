
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        // 가장 가까우면서 크거나 작은 값을 구하고
        // 차이를 구하명 될 거 같은데
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[] broken = new boolean[10];
        int target = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());


        if(num != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < num; i++) {
                int t = Integer.parseInt(st.nextToken());
                broken[t] = true;
            }
        }



        int result = Math.abs(target - 100);
        for (int i = 0; i <= 999999; i++) {

            String s = String.valueOf(i);
            int len = s.length();

            boolean isBreak = false;
            for (int j = 0; j < len; j++) {
                if(broken[s.charAt(j) - '0']){
                    isBreak = true;
                    break;
                }
            }
            if(!isBreak){
                int min = Math.abs(i - target) + len;
                result = Math.min(result, min);
            }
        }

        System.out.println(result);
    }
}
