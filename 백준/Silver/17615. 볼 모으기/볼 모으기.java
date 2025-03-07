
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        char[] chars = br.readLine().toCharArray();

        int tempA= 0;
        // red 넘김

        // 왼쪽으로 넘김
        boolean flag = false;
        for (int i = 0; i < chars.length; i++) {
            if(!flag && chars[i] == 'B'){
                flag = true;
            }else if(flag && chars[i] == 'R'){
                tempA++;
            }
        }

        // 오른쪽으로 넘김 넘김
        flag = false;
        int tempB = 0;
        for (int i = chars.length -1; i >= 0; i--) {
            if(!flag && chars[i] == 'B'){
                flag = true;
            }else if(flag && chars[i] == 'R'){
                tempB++;
            }
        }
        // blue 넘김
        // 왼쪽으로 넘김
        flag = false;
        int tempC = 0;
        for (int i = 0; i < chars.length; i++) {
            if(!flag && chars[i] == 'R'){
                flag = true;
            }else if(flag && chars[i] == 'B'){
                tempC++;
            }
        }

        flag = false;
        int tempD = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if(!flag && chars[i] == 'R'){
                flag = true;
            }else if(flag && chars[i] == 'B'){
                tempD++;
            }
        }

        int answer = Math.min(tempA, Math.min(tempB, Math.min(tempC, tempD)));
        System.out.println(answer);

    }
}
