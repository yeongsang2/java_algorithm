package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20164 {

    static int min = 9999;
    static int max = -1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();

        // number 한자리일때
        // 두자리일때

        int cnt = 0;
        for (int k = 0; k < number.length(); k++) {
            int now = Character.getNumericValue(number.charAt(k));
            if( (now % 2) == 1){ //홀수
                cnt+=1;
            }
        }
        if(number.length() == 1){
            cutOne(number, cnt);
        }else if(number.length() ==2 ){
            cutTwo(number,  cnt);
        }else {
            for (int i = 1; i < number.length()-1; i++) {
                for (int j = i+1; j < number.length(); j++) {
                    cutThree(number, i , j,cnt);
                }

            }
        }
        System.out.println(Integer.toString(min) + " " + Integer.toString(max));

    }
    static void cutThree(String number, int left, int right, int cnt){

        //분할,,
        String first = number.substring(0, left);
        String second = number.substring(left,right);
        String third = number.substring(right,number.length());

        int sum = Integer.parseInt(first) + Integer.parseInt(second) + Integer.parseInt(third);
        String sumStr = Integer.toString(sum);

        int length = Integer.toString(sum).length();

        int count = 0;
        for (int k = 0; k < sumStr.length(); k++) {
            int now = Character.getNumericValue(sumStr.charAt(k));
            if( (now % 2) == 1){ //홀수
                count+=1;
            }
        }

        if( length == 1){
            cutOne(sumStr, cnt + count);
        } else if ( length == 2){
            cutTwo(sumStr, count + cnt);
        } else {
            for (int i = 1; i < sumStr.length()-1; i++) {
                for (int j = i+1; j < sumStr.length(); j++) {
                    cutThree(sumStr, i,j,cnt + count);
                }
            }
        }
    }
    static void cutTwo(String number, int cnt){


        String first = number.substring(0,1);
        String second = number.substring(1,2);

        int sum = Integer.parseInt(first) + Integer.parseInt(second);
        String sumStr = Integer.toString(sum);
        int length = Integer.toString(sum).length();

        int count = 0;
        for (int k = 0; k < sumStr.length(); k++) {
            int now = Character.getNumericValue(sumStr.charAt(k));
            if( (now % 2) == 1){ //홀수
                count+=1;
            }
        }

        if ( length == 1) {
            cutOne(sumStr, cnt + count);
        } else {
            cutTwo(sumStr, cnt + count);
        }
    }

    static void cutOne(String number, int cnt){

        max = Math.max(max, cnt);
        min = Math.min(min, cnt);
        return;
    }
}
