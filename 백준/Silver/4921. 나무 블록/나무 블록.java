
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] arr = {
                {}, // 0
                {}, //1
                {4, 6}, // 2
                {4, 6}, // 3
                {1, 3}, // 4
                {1, 3}, // 5
                {8}, // 6
                {8}, // 7
                {5, 7} // 8
        };
        int idx = 0;
        StringBuilder sb = new StringBuilder();

        while (true){
            idx++;
            String str = br.readLine();
            if(str.length() == 1 && str.charAt(0) == '0') break;
            char[] chars = str.toCharArray();
            int[] numArr = new int[str.length()];
            for (int i = 0; i < numArr.length; i++) {
                numArr[i] = Character.getNumericValue(chars[i]);
            }
            boolean flag = false;
            int[] checked = new int[9];
            for (int i = 0; i < numArr.length; i++) {

                if(i == 0 && numArr[i] != 1){
                    sb.append(idx + ". NOT");
                    flag = true;
                    break;
                }

                if(i == numArr.length - 1 && numArr[i] !=2){
                    sb.append(idx+ ". NOT");
                    flag = true;
                    break;
                }

                if(numArr[i] == 1){
                    if(i != 0) {
                        flag = true;
                        sb.append(idx + ". NOT");
                        break;
                    }
                }

                if(numArr[i] == 5 || numArr[i] == 6){
                    checked[numArr[i]]++;
                }

                if(i == 0) continue;

                int prev = numArr[i-1];
                boolean temp = false;
                for (int t : arr[numArr[i]]) {
                    if(t == prev) {
                        temp = true;
                    }
                }
                if(!temp){
                    flag = true;
                    sb.append(idx + ". NOT");
                    break;
                }
            }

            if(!flag && checked[5] != 0){
                if(checked[5] != checked[6]){
                    flag = true;
                    sb.append(idx + ". NOT");
                }
            }

            if(!flag){
                sb.append(idx + ". VALID");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
