
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int answer = 0;
//        int temp = 0;
        String temp = "";
        int tempSum = 0;
        boolean flag = false;
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);

            if(c == '+'){
                // 괄호 안일때
                int num = Integer.parseInt(temp);
                if(flag){
                    tempSum += num;
                }else{  // 괄호 밖일때
                    answer += num;
                }
                temp = "";
            }else if(c == '-'){
                if(flag){
                    int num = Integer.parseInt(temp);
                    num += tempSum;
                    answer -= num;
                }else{ //새시작
                    flag = true;
                    int num = Integer.parseInt(temp);
                    answer += num;
                }
                tempSum =0;
                temp = "";
            }else{
                temp += c;
            }
        }
        if(flag){
            tempSum += Integer.parseInt(temp);
            answer -= tempSum;
        }else{
            answer += Integer.parseInt(temp);
        }

        System.out.println(answer);

    }
}
