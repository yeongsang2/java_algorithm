package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boJ_2588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();
        for(int i=2 ; i>=0; i--){
            System.out.println(Integer.parseInt(a)*Character.getNumericValue(b.charAt(i)));
        }
        System.out.println(Integer.parseInt(a) * Integer.parseInt(b));

    }
}
