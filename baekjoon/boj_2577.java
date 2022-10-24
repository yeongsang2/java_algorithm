package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2577 {
    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        int[] answer = new int[10];
        long result = a*b*c;

        String s = String.valueOf(result);
        for(int i=0;i<s.length();i++){
            int num = Character.getNumericValue(s.charAt(i));
            answer[num]++;
        }

        for(int i=0; i<10;i++){
            System.out.println(answer[i]);
        }


    }
}
