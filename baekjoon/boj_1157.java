package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class boj_1157 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase();
        int[] list = new int[27];

        for(int i=0; i<str.length();i++){
            char c = str.charAt(i);
            list[c-97]++;
        }

        int result = Integer.MIN_VALUE;
        char answer = '?';
        for(int i=0;i<list.length;i++){
            if( result < list[i]){
                answer = (char )(i + 97);
                answer = Character.toUpperCase(answer);
                result = list[i];
            }else if( result == list[i]){
                answer = '?';
            }
        }
        System.out.println(answer);


    }
}
