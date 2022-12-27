package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1427 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] array;
        String s = br.readLine();
        array = new Integer[s.length()];
        for(int i=0; i< s.length(); i++){
            array[i] = Character.getNumericValue(s.charAt(i));
        }
        Arrays.sort(array, Collections.reverseOrder());
        for(Integer i : array){
            System.out.print(i);
        }

    }
}
