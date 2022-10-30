package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11719 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        String[] result = new String[100];
        for(int i=0; i<100;i++){
            str = br.readLine();
            result[i] = str;
        }
        for(int i=0; i<100;i++){
            System.out.println(result[i]);
        }

    }
}
