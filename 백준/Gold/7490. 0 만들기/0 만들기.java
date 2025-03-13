
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static char[] arr = {',', '+', '-'};
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0){

            int num = Integer.parseInt(br.readLine());

            search(1, num, "+1");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void search(int idx, int num, String path){
        if(idx == num){
            int sum = 0;
            for (int i = 0; i < path.length(); ) {
                String temp = "";
                char op = path.charAt(i);
                int lastIdx = i;
                if(!Character.isDigit(op)){
                    for (int j = i + 1; j < path.length(); j++) {
                        if(path.charAt(j) == ' ') continue;
                        lastIdx = j;
                        if(Character.isDigit(path.charAt(j))) {
                            temp += path.charAt(j);
                        }else{
                            break;
                        }
                    }
                    if(op == '+') {
                        sum += Integer.parseInt(temp);
                    }else if(op == '-'){
                        sum -= Integer.parseInt(temp);
                    }
                }
                i = lastIdx;
                if(i == path.length() - 1) i++;
            }
            if(sum == 0) sb.append(path.substring(1, path.length())).append("\n");
            return;
        }

        for (int i = 0; i < 3; i++) {
            if(i == 0){
                search(idx + 1, num, path + ' ' + Integer.toString(idx + 1));
            }else{
                search(idx+1, num, path + arr[i] + Integer.toString(idx + 1));
            }
        }

    }
}
