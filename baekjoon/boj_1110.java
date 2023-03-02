package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        int cycle = 0;
        int newNumber = Integer.parseInt(number);
        int helpNumber;


        while (true){
            cycle++;
            String str = String.valueOf(newNumber);
            if(newNumber < 10){
                helpNumber = newNumber;
            }else{
                helpNumber = (Character.getNumericValue(str.charAt(0)) + Character.getNumericValue(str.charAt(1)))% 10;
            }
//            helpNumber = Character.getNumericValue(str.charAt(0)) + Character.getNumericValue(str.charAt(1)) % 10;
            String newNumStr =  String.valueOf(newNumber % 10) + String.valueOf(helpNumber);
            newNumber = Integer.parseInt(newNumStr);
            if(newNumber == Integer.parseInt(number)){
                System.out.println(cycle);
                break;
            }
        }

    }
}
