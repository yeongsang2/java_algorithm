package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb;
        StringBuilder answer = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String input = br.readLine();
            int first = 0;
            int end = input.length() - 1;

            sb = new StringBuilder(input);
            int flag = 2;

            if (input.equals(sb.reverse().toString())) {
                flag = 0;

            } else {
                while (first < end) {
                    if(input.charAt(first) != input.charAt(end)){
                        StringBuilder leftBuilder = new StringBuilder(input).deleteCharAt(first);
                        StringBuilder rightBuilder= new StringBuilder(input).deleteCharAt(end);

                        if( (leftBuilder.toString().equals(leftBuilder.reverse().toString())) || rightBuilder.toString().equals(rightBuilder.reverse().toString())){
                            flag = 1;
                        }
                        break;
                    }
                    first +=1;
                    end -=1;
                }
            }
            answer.append(flag);
            answer.append("\n");
        }
        answer.deleteCharAt(answer.length()-1);
        System.out.println(answer.toString());
    }
}
