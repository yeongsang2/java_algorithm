package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;

public class boj_21314 {

    static BigInteger maxNum;
    static BigInteger minNum;
    static String str;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        maxResult(0,0, "");
        minResult(0,0, "");

        System.out.println(maxNum);
        System.out.println(minNum);

    }

    private static void maxResult(int index, int count, String total) {

        if(index == str.length() -1 ){
            if(str.charAt(index) == 'M'){
                String add = "1";
                for (int i = 0; i < count; i++) {
                    add = add + "1";
                }
                total = total +add;
            }else {
                String add = "5";
                for (int i = 0; i < count; i++) {
                    add = add + "0";
                }
                total = total +add;
            }
            maxNum = new BigInteger(total);
            return;
        }

        if(str.charAt(index) == 'K'){
            String add = "5";
            for (int i = 0; i < count; i++) {
                add = add + "0";
            }
            maxResult(index +1 ,0, total + add);
        }else {
            maxResult(index +1, count+1, total);
        }
    }

    private static void minResult(int index, int count, String total) {

        if(index == str.length() -1 ){
            if(str.charAt(index) == 'M'){
                String add = "1";
                for (int i = 0; i < count; i++) {
                    add = add + "0";
                }
                total = total +add;
            }else {
                String add = "5";
                for (int i = 0; i < count; i++) {
                    add = add + "0";
                }
                total = total +add;
            }
            minNum= new BigInteger(total);
            return;
        }
        if(str.charAt(index) == 'M'){
            if(str.charAt(index+1) == 'K'){
                String add = "1";
                for (int i = 0; i < count; i++) {
                    add = add + "0";
                }
                minResult(index+1, 0, total + add );
            }else {
                minResult(index+1, count+1, total);
            }
        }

        if(str.charAt(index) == 'K'){
            String add = "5";
            minResult(index+1, 0,total + add);
        }
    }
}
