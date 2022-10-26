package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11720 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = 0;

        for(int i = 0;i <str.length();i++){
            result += Character.getNumericValue(str.charAt(i));
        }
        System.out.println(result);


    }
}
