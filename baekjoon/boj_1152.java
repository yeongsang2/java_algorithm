package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1152 {

    public static void main(String[] args) throws IOException {

        String str;
        int result = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();

        if (str.length() == 1) {
            if(str.charAt(0) == ' '){
                System.out.println(0);
            }else {
                System.out.println(1);
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == ' ') {
                    if (i == 0 || i == str.length() - 1) {

                    } else {
                        result++;
                    }
                }
            }
            System.out.println(result + 1);
        }
    }
}
